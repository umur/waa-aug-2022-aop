package com.miu.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
@Aspect
@Component
public class AopImpl {
    @Autowired
    private HttpServletRequest httpServletRequest;
    @Pointcut("within(com.miu.aop.controller.*)\")")
    public void checkHeaderException(){};

    @Around("checkHeaderException()")
    public void checkException(ProceedingJoinPoint joinPoint) throws Throwable{
        if(httpServletRequest.getMethod().equals(RequestMethod.POST) && httpServletRequest.getHeader("AOP-IS-AWESOME") ==null){
            Object obj = joinPoint.proceed();
        }else{
            throw new AopIsAwesomeHeaderException("Aop exception");
        }
    }
}
