package com.example.lab5aop.aop;

import com.example.lab5aop.domain.ActivityLog;
import com.example.lab5aop.repository.ActivityLogRepository;
import lombok.AllArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Aspect
@AllArgsConstructor
public class ActivityLogAspect {

    private ActivityLogRepository activityLogRepository;

    @Pointcut("@annotation(com.example.lab5aop.aop.ExecutionTime)")
    public void executionTime() {}

    @Around("executionTime()")
    public Object calExTimeAndSave(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        double start = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        double end = System.currentTimeMillis();
        LocalDate localDate = LocalDate.now();
        activityLogRepository.save(new ActivityLog(1, localDate, proceedingJoinPoint.getSignature().getName(), end - start));
        return result;
    }

}
