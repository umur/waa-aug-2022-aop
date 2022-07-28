package com.miu.edu.lab4springaop.aspect;

import com.miu.edu.lab4springaop.entity.ActivityLog;
import com.miu.edu.lab4springaop.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Aspect
@Component
@RequiredArgsConstructor
public class ActivityAspect {
    private final ActivityLogService activityLogService;

    @Pointcut("@annotation(com.miu.edu.lab4springaop.annotation.ExecutionTime)")
    public void runtime() {}

    @Around("runtime()")
    public Object executionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = proceedingJoinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        System.out.println("executionTime: " + executionTime);
        activityLogService.save(ActivityLog.builder().date(LocalDate.now()).
                operation(proceedingJoinPoint.getSignature().getName()).
                duration(executionTime).build());

        return proceed;
    }
}
