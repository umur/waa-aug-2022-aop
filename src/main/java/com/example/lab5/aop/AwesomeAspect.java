package com.example.lab5.aop;

import com.example.lab5.exceptions.AopIsAwesomeHeaderException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class AwesomeAspect {

    @Pointcut("@annotation(com.example.lab5.aop.annotation.AwesomeCheck)")
    public void awesome() {}

    @Before("awesome()")
    public void awesomcheck(JoinPoint joinPoint) throws AopIsAwesomeHeaderException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String header = request.getHeader("AOP-IS-AWESOME");
        if(header == null) throw new AopIsAwesomeHeaderException();
    }

}
