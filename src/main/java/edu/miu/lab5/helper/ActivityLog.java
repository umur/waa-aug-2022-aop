package edu.miu.lab5.helper;

import edu.miu.lab5.repository.ActivityLogRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Enumeration;

@Aspect
@Component
@RequiredArgsConstructor
public class ActivityLog {
    private ActivityLogRepository activityLogRepository;

    @Pointcut("@annotation(edu.miu.lab5.helper.ExecutionTime)")
    public void executionTime() {}

    @Around("executionTime()")
    public Object calExTimeAndSave(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes())
                .getRequest();

        boolean iAOPIsAwesome = false;

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = (String) headerNames.nextElement();
            if (headerName.equalsIgnoreCase("AOP-IS-AWESOME")) iAOPIsAwesome = true;
        }

        if (!iAOPIsAwesome) throw new AopIsAwesomeHeaderException();

        long start = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        LocalDate localDate = LocalDate.now();
        activityLogRepository.save(new edu.miu.lab5.entity.ActivityLog(1, localDate.toString(), proceedingJoinPoint.getSignature().getName(), end - start));
        return result;
    }
}
