package miu.edu.springaoplab5.utils;

import lombok.AllArgsConstructor;
import miu.edu.springaoplab5.models.ActivityLog;
import miu.edu.springaoplab5.services.ActivityLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
@AllArgsConstructor
public class LoggerUtil {
    private final ActivityLogService service;
    @Pointcut("@annotation(miu.edu.springaoplab5.annotations.ExecutionTime)")
    public void executionTime(){};

    @Around("executionTime()")
    public Object saveLog(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object results = joinPoint.proceed();
        long end = System.currentTimeMillis();

        ActivityLog activityLog = new ActivityLog();
        activityLog.setDate(new Date());
        var signature = joinPoint.getSignature();
        activityLog.setOperation(signature.getDeclaringTypeName().concat("/").concat(signature.getName()));
        activityLog.setDuration(end-start);

        service.save(activityLog);
        return results;
    }
}
