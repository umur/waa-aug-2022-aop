package edu.miu.lab5.aspect;

import edu.miu.lab5.entity.ActivityLog;
import edu.miu.lab5.service.IActivityService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class ExecutionTimeAspect {

    IActivityService activityService;

    public ExecutionTimeAspect(IActivityService activityService) {
        this.activityService = activityService;
    }

    @Pointcut("@annotation(edu.miu.lab5.anotation.ExecutionTime)")
    void run() {
    }


    @Around("run()")
    public Object executionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start2 = System.currentTimeMillis();
        var result = proceedingJoinPoint.proceed();
        long end2 = System.currentTimeMillis();

        buildAndSaveActivity(proceedingJoinPoint,end2-start2);
        return result;
    }

    private void buildAndSaveActivity(ProceedingJoinPoint proceedingJoinPoint,long duration){
        var activity=new ActivityLog();
        activity.setDate(new Date().toString());
        activity.setDuration(duration+"");
        activity.setOperation(proceedingJoinPoint.getTarget().toString());
        activityService.save(activity);
    }
}
