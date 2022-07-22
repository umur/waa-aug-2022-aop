package lab5.aop.helper;

import lab5.aop.entity.ActivityLog;
import lab5.aop.repository.ActivityLogRepository;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
public class AspectExecutionTime {
    private ActivityLogRepository repo;

    @Autowired
    public AspectExecutionTime(ActivityLogRepository repo) {
        this.repo = repo;
    }

    @Pointcut("@annotation(lab5.aop.helper.ExecutionTime)")
    public void execFunc() {
    }

    @Around("execFunc()")
    public Object logExecTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        repo.save(new ActivityLog(0, new Date(), proceedingJoinPoint.getSignature().getName(), end - start));
        return result;
    }
}
