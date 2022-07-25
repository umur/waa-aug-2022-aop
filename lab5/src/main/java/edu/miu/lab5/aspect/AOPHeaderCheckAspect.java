package edu.miu.lab5.aspect;

import edu.miu.lab5.exception.AopIsAwesomeHeaderException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class AOPHeaderCheckAspect {

    @Pointcut("within(edu.miu.lab5.controller.*)")
    public void check(){}

    @Around("check()")
    public Object run(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {


        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        if(request.getMethod().toLowerCase().equals("post")){
            String aopHeader = request.getHeader("AOP-IS-AWESOME");
            if (aopHeader == null) {
                throw new AopIsAwesomeHeaderException("Please add AOP-IS-AWESOME header");
            }
        }
        return proceedingJoinPoint.proceed();
    }
}
