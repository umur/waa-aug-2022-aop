package miu.edu.lab05.helper;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Aspect
@Component
@RequiredArgsConstructor
public class AwesomeChecker {

    private final HttpServletRequest request;
    @Pointcut("within(miu.edu.lab05.service..*)")
    public void packageCheck() {}

    @Before("packageCheck()")
    public void runHeader(JoinPoint joinPoint) throws AopIsAwesomeHeaderException {
        String header = request.getHeader("AOP-IS-AWESOME");
        String method = request.getMethod();
        if (Objects.isNull(header) && method.equals(HttpMethod.POST.toString())) {
            throw new AopIsAwesomeHeaderException("aop header check requires AOP-IS-AWESOME in POST request");
        }
    }
}
