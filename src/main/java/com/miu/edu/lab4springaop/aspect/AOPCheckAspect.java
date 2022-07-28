package com.miu.edu.lab4springaop.aspect;

import com.miu.edu.lab4springaop.exception.AopIsAwesomeException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class AOPCheckAspect {

    @Pointcut("within(com.miu.edu.lab4springaop.controller.*)")
    public void check(){}

    @Around("check()")
    public Object run(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        if(request.getMethod().toLowerCase().equals("post")){
            String aopHeader = request.getHeader("AOP-IS-AWESOME");
            if (aopHeader == null) {
                throw new AopIsAwesomeException("Please add AOP-IS-AWESOME header");
            }
        }
        return proceedingJoinPoint.proceed();
    }
}
