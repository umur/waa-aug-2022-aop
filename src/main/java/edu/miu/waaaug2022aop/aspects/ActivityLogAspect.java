package edu.miu.waaaug2022aop.aspects;

import edu.miu.waaaug2022aop.entity.ActivityLog;
import edu.miu.waaaug2022aop.repository.ActivityLogRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Aspect
@Component
@RequiredArgsConstructor
public class ActivityLogAspect {

    private final ActivityLogRepository activityLogRepository;

    @Around("@annotation(edu.miu.waaaug2022aop.annotation.ExecutionTime)")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        var start = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        var end = System.currentTimeMillis();
        LocalDate localDate = LocalDate.now();
        activityLogRepository.save(new ActivityLog(1, localDate, proceedingJoinPoint.getSignature().getName(), end - start));
        return result;
    }
}
