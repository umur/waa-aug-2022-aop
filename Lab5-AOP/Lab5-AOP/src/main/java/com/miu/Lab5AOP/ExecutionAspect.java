package com.miu.Lab5AOP;

import com.miu.Lab5AOP.entity.ActivityLog;
import com.miu.Lab5AOP.repository.ActivityLogRepo;
import com.miu.Lab5AOP.service.ActivityLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class ExecutionAspect {

    private ActivityLogRepo activityLogRepo;

    public ExecutionAspect(ActivityLogRepo activityLogRepository){
        this.activityLogRepo = activityLogRepository;
    }

    @Pointcut("@annotation(com.miu.Lab5AOP.ExecutionTime)")
    public void runtime(){}

    @Around("runtime()")
    public Object myMethod(ProceedingJoinPoint pjp) throws Throwable{
        long start = System.currentTimeMillis();

        Object result = pjp.proceed();

        long end = System.currentTimeMillis();
        long totalExecution = end-start;
        ActivityLog log = new ActivityLog();
        log.setDate(new Date());
        log.setDuration(totalExecution);
        log.setOperation(pjp.getSignature().getName());
        activityLogRepo.save(log);
        return result;
    }
}
