package com.example.aop.aspect;

import com.example.aop.exception.AopIsAwesomeException;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
@RequiredArgsConstructor
public class HeaderCheckAspect {
    private final HttpServletRequest httpServletRequest;

    @Pointcut("within(com.example.aop.service.impl.*)")
    public void headerCheck(){
    }

    @Before("headerCheck()")
    public void checkHeaderForMessage(JoinPoint joinPoint) throws AopIsAwesomeException {
        String header = httpServletRequest.getHeader("AOP-IS-AWESOME");
        String method = httpServletRequest.getMethod();
        if (method.equals(HttpMethod.POST.toString()) && ObjectUtils.isEmpty(header)){
            throw new AopIsAwesomeException("Post request does not contain AOP-IS-AWESOME in header");
        }
    }
}
