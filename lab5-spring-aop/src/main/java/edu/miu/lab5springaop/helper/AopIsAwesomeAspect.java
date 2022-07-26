package edu.miu.lab5springaop.helper;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@RequiredArgsConstructor
public class AopIsAwesomeAspect {

    private final HttpServletRequest request;

    @Pointcut("within(edu.miu.lab5springaop.service..*)")
    public void packageCheck() {}

    @Before("packageCheck()")
    public void headerChecker(JoinPoint joinPoint) throws AopIsAwesomeHeaderException {
        String header = request.getHeader("AOP-IS-AWESOME");
        String method = request.getMethod();
        if(header == null && method.equals(HttpMethod.POST.toString())) {
            throw new AopIsAwesomeHeaderException("POST reqeust needs to have AOP-IS-AWESOME header");
        }
    }
}
