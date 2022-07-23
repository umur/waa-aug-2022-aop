package cs545waa.lab5.helper;

import cs545waa.lab5.entity.ActivityLog;
import cs545waa.lab5.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
@Aspect
public class ExecutionTimeAspect {

    private final ActivityLogService activityLogService;

    @Pointcut("@annotation(cs545waa.lab5.helper.ExecutionTime)")
    public void runtime(){}

    @Around("runtime()")
    public Object calculate(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        ActivityLog activityLog = new ActivityLog();
        activityLog.setTimestamp(new Date());
        activityLog.setOperation(proceedingJoinPoint.getSignature().getDeclaringTypeName() + "." + proceedingJoinPoint.getSignature().getName());
        activityLog.setDuration(end - start);
        activityLogService.create(activityLog);
        return result;
    }
}
