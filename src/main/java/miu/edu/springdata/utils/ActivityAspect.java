package miu.edu.springdata.utils;

import miu.edu.springdata.entity.ActivityLog;
import miu.edu.springdata.service.ActivityLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Aspect
@Component
public class ActivityAspect {
    private final ActivityLogService activityLogService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    public ActivityAspect(ActivityLogService activityLogService) {
        this.activityLogService = activityLogService;
    }

    @Pointcut("@annotation(miu.edu.springdata.utils.ExecutionTime)")
    public void runtime(){}

    @Around("runtime()")
    public Object calculate(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long start = System.currentTimeMillis();

        Object proceed = proceedingJoinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        System.out.println("executionTime = " + executionTime + "ms");

        activityLogService.saveLog(ActivityLog.builder().date(LocalDate.now()).operation(proceedingJoinPoint.getSignature().getName()).duration(executionTime).build());

        return proceed;
    }

    @Pointcut("execution(* miu.edu.springdata.service.*.*(..))")
    public void checkHeader(){}

    @Before("checkHeader()")
    public void check() {
        String method = httpServletRequest.getMethod();
        System.out.println("method = " + method);
        if (!method.equals("POST")) {
            return;
        }
        String header = httpServletRequest.getHeader("AOP-IS-AWESOME");
        System.out.println("header = " + header);
        if ( header == null) {
            throw new AopIsAwesomeHeaderException();
        }

    }
}
