package miu.edu.lab05.helper;

import lombok.RequiredArgsConstructor;
import miu.edu.lab05.models.ActivityLog;
import miu.edu.lab05.service.ActivityLogServiceImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
@RequiredArgsConstructor
public class RuntimeHelper {

    private final ActivityLogServiceImpl activityLogService;

    @Pointcut("@annotation(miu.edu.lab05.helper.ExecutionTime)")
    public void executor() {}

    @Around("executor()")
    public Object calculate(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
        activityLogService.save(new ActivityLog(null,
                LocalDateTime.now(),
                proceedingJoinPoint.getSignature().getName(),
                end - start));
        return result;
    }
}
