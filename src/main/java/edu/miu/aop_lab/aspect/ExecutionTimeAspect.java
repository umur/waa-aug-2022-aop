package edu.miu.aop_lab.aspect;

import edu.miu.aop_lab.dto.ActivityLogDto;
import edu.miu.aop_lab.service.ActivityLogService;
import lombok.AllArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Aspect
@Component
public class ExecutionTimeAspect {

    @Autowired
    private  ActivityLogService activityLogService;

    @Around("@annotation(edu.miu.aop_lab.annotations.ExecutionTime)")
    public Object calculateExecutionandLogTime(ProceedingJoinPoint pjp) throws Throwable
    {
        LocalDate d = LocalDate.now();
        long start = System.nanoTime();
        var result = pjp.proceed();
        long finish = System.nanoTime();
        long duration = finish - start ;
        String operation = pjp.getSignature().getName();

        ActivityLogDto activityLogDto = new ActivityLogDto(d , operation , duration);
        activityLogService.addActivityLog(activityLogDto);
        return result;
    }
}
