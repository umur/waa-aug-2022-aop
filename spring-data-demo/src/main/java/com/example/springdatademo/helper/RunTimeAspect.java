package com.example.springdatademo.helper;

import com.example.springdatademo.entity.ActivityLog;
import com.example.springdatademo.repository.ActivityLogRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Aspect
@Component
@RequiredArgsConstructor
public class RunTimeAspect {

    private final ActivityLogRepository activityLogRepository;

    @Pointcut("@annotation(com.example.springdatademo.annotation.ExecutionTime)")
    public void runtime() {
    }

    @Around("runtime()")
    public Object calculate(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        ActivityLog activityLog= new ActivityLog();
        activityLog.setDate(LocalDate.now());
        activityLog.setDuration(end-start);
        activityLog.setOperation(proceedingJoinPoint.getSignature().toShortString());
        activityLogRepository.save(activityLog);
        return result;
    }
}
