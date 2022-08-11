package edu.miu.lab5.helper;

import edu.miu.lab5.exception.AopIsAwesomeHeaderException;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
@RequiredArgsConstructor
public class AopHeaderAspect {
     private final HttpServletRequest httpRequest ;
     Map<String, String> stringStringMap = new HashMap<>();

     //@Pointcut("within(edu.miu.lab5.service..*)")
    @Pointcut("@annotation(edu.miu.lab5.helper.ExecutionTime)")
    public void after(){}

    @Pointcut("within(edu.miu.lab5.service..*)")
    public void around(){}

    @After("after()")
    public  void calculate(JoinPoint joinPoint){
        System.out.println("=========================After=====================");
    }

    @Around("around()")
    public Object checkAopHeader(ProceedingJoinPoint joinPoint) throws Throwable {

        String m = httpRequest.getMethod();
        if(m.equals("POST")){
            String h = httpRequest.getHeader("AOP-IS-AWESOME");
            if(h==null){
                throw new AopIsAwesomeHeaderException("AOP-IS-AWESOME is missing");
            }
        }


        Object result = joinPoint.proceed();
        return  result;
    }
}
