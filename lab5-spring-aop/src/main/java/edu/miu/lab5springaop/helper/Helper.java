package edu.miu.lab5springaop.helper;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Helper {

    @Pointcut("@annotation(edu.miu.lab5springaop.helper.HelloWorld)")
    public void a() {

    }

    @Before("a()")
    public void print(JoinPoint joinPoint) {
        System.out.println("Hello World");
    }
}
