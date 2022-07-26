package com.javokhir.lab5.aspect;

import com.javokhir.lab5.domain.ActivityLog;
import com.javokhir.lab5.exception.AopIsAwesomeHeaderException;
import com.javokhir.lab5.repository.ActivityLogRepository;
import lombok.AllArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import java.net.http.HttpRequest;
import java.util.Date;

@Aspect
@Component
@AllArgsConstructor
public class ActivityLogAspect {

    private final ActivityLogRepository repository;
    private final HttpServletRequest request;

    @Pointcut("execution(* com.javokhir.lab5.service.*.*(..))")
    public void awesomeCheckPointCut() {
    }

    @Pointcut("@annotation(com.javokhir.lab5.annotation.ExecutionTime)")
    public void logPointCut() {
    }

    @Around("logPointCut()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        long stopTime;
        Object value;
        try {
            value = joinPoint.proceed();
        } finally {
            stopTime = System.currentTimeMillis();

            repository.save(ActivityLog.builder()
                    .date(new Date())
                    .operation(joinPoint.getSignature().getName())
                    .duration(stopTime - startTime)
                    .build());
        }

        return value;
    }

    @Before("awesomeCheckPointCut()")
    public void checkAwesomeAdvise(JoinPoint joinPoint) {
        if (!request.getMethod().equalsIgnoreCase(HttpMethod.POST.name())) {
            return;
        }

        if (request.getHeader("AOP-IS-AWESOME") == null) {
            throw new AopIsAwesomeHeaderException();
        }
    }
}
