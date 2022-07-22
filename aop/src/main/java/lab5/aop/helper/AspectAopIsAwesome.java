package lab5.aop.helper;

import lab5.aop.exception.AopIsAwesomeHeaderException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class AspectAopIsAwesome {
    @Autowired
    private HttpServletRequest request;

    @Pointcut("execution(* lab5.aop.service..*(..)))")
    public void func() {
    }

    @Before("func()")
    public void before(JoinPoint joinPoint) {
        if (request.getMethod().equals("POST")) {
            var headerExist = request.getHeader("AOP-IS-AWESOME");
            if (headerExist != null && !headerExist.equals(""))
                throw new AopIsAwesomeHeaderException("AOP-IS-AWESOME");
        }
    }
}
