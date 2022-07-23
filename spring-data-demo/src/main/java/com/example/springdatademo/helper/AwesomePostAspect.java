package com.example.springdatademo.helper;

import com.example.springdatademo.exception.AopIsAwesomeHeaderException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class AwesomePostAspect {
    @Before("@annotation(com.example.springdatademo.annotation.AwesomePost)")
    public void checkAwesomePost(JoinPoint joinPoint) throws AopIsAwesomeHeaderException {
        HttpServletRequest httpServletRequest=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String header = httpServletRequest.getHeader("AOP-IS-AWESOME");
        if(header == null) throw new AopIsAwesomeHeaderException("AOP-IS-AWESOME header doesn't exist");
    }
}
