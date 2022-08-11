package edu.miu.waaaug2022aop.aspects;

import edu.miu.waaaug2022aop.exceptions.AopIsAwesomeHeaderException;
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

    @Before("@annotation(edu.miu.waaaug2022aop.annotation.AwesomePost)")
    public void isAwesomePost(JoinPoint joinPoint) throws AopIsAwesomeHeaderException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes())
                .getRequest();
        String header = request.getHeader("AOP-IS-AWESOME");
        if(header == null) throw new AopIsAwesomeHeaderException("AOP-IS-AWESOME header doesn't exist");
    }
}
