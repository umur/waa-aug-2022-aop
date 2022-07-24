package com.example.lab5.aop;

import com.example.lab5.dto.LogDto;
import com.example.lab5.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Aspect
@Component
public class TimerAspect {

    @Autowired
    LogService logService;

    @Pointcut("@annotation(com.example.lab5.aop.annotation.ExecutionTime)")
    public void timerFunc(){}

    @Around("timerFunc()")
    public Object calcTimer(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        var start = System.currentTimeMillis();
        Object objRes = proceedingJoinPoint.proceed();
        var end = System.currentTimeMillis();
        LogDto logDto = new LogDto(LocalDate.now(), proceedingJoinPoint.getSignature().getName(), (end-start));
        logService.saveActivityLog(logDto);
        //System.out.printf("Time taken for method %s is %ld", proceedingJoinPoint.getSignature().getName(), (end-start));
        return objRes;
    }

}
