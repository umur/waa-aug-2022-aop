package com.miu.aop.aspect;

import com.miu.aop.repository.ActivityLogRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Aspect
@Component
@RequiredArgsConstructor
public class ActivityLog {
    @Autowired
    private ActivityLogRepository activityLogRepository;

    public ActivityLog(ActivityLogRepository activityLogRepository){
        this.activityLogRepository = activityLogRepository;
    }

    @Pointcut("@annotation(com.miu.aop.aspect.ExecutionTime)")
    public void executionTimeAnnotation() {
    }

    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        String packageName = proceedingJoinPoint.getSignature().getDeclaringTypeName();
        String methodName = proceedingJoinPoint.getSignature().getName();
        ActivityLog activityLog = new ActivityLog(LocalDate.now(),String.format("Class: %s, method: %s",packageName,methodName),finish-start);
        activityLogRepository.save(activityLog);
        return result;
    }
}
