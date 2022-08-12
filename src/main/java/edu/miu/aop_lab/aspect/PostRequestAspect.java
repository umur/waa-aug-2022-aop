package edu.miu.aop_lab.aspect;

import edu.miu.aop_lab.exception.AopIsAwesomeException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Map;

@Aspect
@Component
public class PostRequestAspect {

    @After("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void aopIsAwesomeInHeader(JoinPoint jp)
    {
        System.out.println("Aspect started.....");
        Object[] args = jp.getArgs();
        Map<String,String> headers = (Map<String, String>) args[0];
        headers.forEach((key, value)->{
            /// Set the cookie header in postman with "AOP-IS-AWESOME" for testing
            if(!value.equals("AOP-IS-AWESOME"))
            {

                throw new AopIsAwesomeException();
            }
            else
            { System.out.println("Here we go ........");}
        });
    }
}
