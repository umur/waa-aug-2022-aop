package lab5.aop.helper;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectAopIsAwesome {
    @Pointcut("within(@lab5.aop.service *)")
    public void func(){}

    @Before("func()")
    public void before(JoinPoint joinPoint){
        System.out.print("asd");
    }
}
