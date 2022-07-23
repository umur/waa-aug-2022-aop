package com.example.lab5aop.aop;

import com.example.lab5aop.exception.AopIsAwesomeHeaderException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class AwesomePostAspect {
    @Before("@annotation(com.example.lab5aop.aop.AwesomeHeader)")
    public void isAwesomePost(JoinPoint joinPoint) throws AopIsAwesomeHeaderException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes())
                .getRequest();
        String header = request.getHeader("AOP-IS-AWESOME");
        if(header == null) throw new AopIsAwesomeHeaderException("AOP-IS-AWESOME header doesn't exist");
    }
}
