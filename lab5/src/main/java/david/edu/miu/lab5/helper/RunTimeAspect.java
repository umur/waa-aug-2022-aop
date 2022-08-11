package david.edu.miu.lab5.helper;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class RunTimeAspect {

    @Autowired
    HttpServletRequest httpServletRequest ;
    @Pointcut("@annotation(david.edu.miu.helper.ExecutionTime)")
    public  void runTime(){}

    @Around("runTime()")
    public void log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        if (httpServletRequest.getHeader().contains("AOP-IS-AWESOME")) {


            long start = System.currentTimeMillis();
            // call the method
            proceedingJoinPoint.proceed(); // next
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        }
    }

}
