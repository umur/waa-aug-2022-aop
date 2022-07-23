package edu.miu.aspect;

import edu.miu.exception.AopIsAwesomeException;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@RequiredArgsConstructor
public class AwesomeHeaderCheck {
    private final HttpServletRequest httpServletRequest;

    @Pointcut(" within(edu.miu.service.impl.*)")
    public void checkingPackage() {
    }

    @Before("checkingPackage()")
    public void validateHeader(JoinPoint joinPoint) throws AopIsAwesomeException {
        String header = httpServletRequest.getHeader("AOP-IS-AWESOME");
        String method = httpServletRequest.getMethod();
        if (method.equals(HttpMethod.POST.toString()) && ObjectUtils.isEmpty(header)) {
            throw new AopIsAwesomeException("AOP-IS-AWESOME is not found in POST request");
        }
    }
}
