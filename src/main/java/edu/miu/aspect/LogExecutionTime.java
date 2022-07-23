package edu.miu.aspect;

import edu.miu.entity.ActivityLog;
import edu.miu.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@RequiredArgsConstructor
@Aspect
@Component
public class LogExecutionTime {
    private final ActivityLogService activityLogService;

    @Pointcut("@annotation(edu.miu.annotation.ExecutionTime)")
    public void loggingPointCut() {
    }

    @Around("loggingPointCut()")
    public Object logExecTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        long duration = end - start;
        System.out.println("Duration in ms: " + duration);
        activityLogService.save(new ActivityLog(LocalDate.now(), proceedingJoinPoint.getSignature().getName(), duration));
        return result;
    }
}
