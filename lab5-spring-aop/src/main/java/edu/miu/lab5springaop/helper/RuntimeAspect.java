package edu.miu.lab5springaop.helper;

import edu.miu.lab5springaop.Entity.ActivityLog;
import edu.miu.lab5springaop.Repository.ActivityLogRepo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class RuntimeAspect {

    @Autowired
    private ActivityLogRepo activityLogRepo;

    @Pointcut("@annotation(edu.miu.lab5springaop.helper.ExecutionTime)")
    public void runtime(){}

    @Around("runtime()")
    public Object calculate(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        //call the method
        Object result = proceedingJoinPoint.proceed(); //next

        long end = System.currentTimeMillis();

        ActivityLog activityLog = new ActivityLog();
        activityLog.setDate(LocalDateTime.now());
        activityLog.setOperation(proceedingJoinPoint.getSignature().getName());
        activityLog.setDuration(end - start);
        activityLogRepo.save(activityLog);

        //return the result
        return result;
    }
}
