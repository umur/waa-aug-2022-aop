package com.miu.Lab5AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class MyAspect {

    private HttpServletRequest httpServletRequest;

    public MyAspect(HttpServletRequest httpServletRequest){
        this.httpServletRequest=httpServletRequest;
    }

    @Pointcut(value = "execution(* com.miu.Lab5AOP.service.Impl.*.*(..))")
    public void isAwesome(){}

    @Around("isAwesome()")
    public Object MyMethod(ProceedingJoinPoint pjp) throws Throwable{
        if(httpServletRequest.getMethod().equals("POST") && httpServletRequest.getHeader("AOP-IS-AWESOME") == null){
            throw new AopIsAwesomeHeaderException("Not Valid headers");
        }
        else {
            Object result = pjp.proceed();
            return result;
        }
    }
}
