package com.example.aop.aspect;

import com.example.aop.model.ActivityLog;
import com.example.aop.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Aspect
@RequiredArgsConstructor
public class ExecutionTimeAspect {
    private final ActivityLogService activityLogService;

    @Pointcut("@annotation(com.example.aop.annotation.ExecutionTime)")
    public void logPointCut(){
    }

    @Around("logPointCut()")
    public Object logExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long startTime = System.currentTimeMillis();
        Object res = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();

        long timePeriod = endTime - startTime;

        activityLogService.save(
                new ActivityLog(null, LocalDate.now(),
                        proceedingJoinPoint.getSignature().getName(),
                        timePeriod)
        );

        return res;
    }
}
