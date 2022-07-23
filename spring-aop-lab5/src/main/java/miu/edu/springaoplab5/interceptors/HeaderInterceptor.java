package miu.edu.springaoplab5.interceptors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.net.http.HttpHeaders;
import java.util.Locale;
import java.util.Map;

@Aspect
@Component
public class HeaderInterceptor {

    @Pointcut("within(miu.edu.springaoplab5.contrtollers.*)")
    public void controllerMethods(){};

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void httpPost(){};

    @Before("controllerMethods() && httpPost() && args(..,httpHeaders)")
    public void interceptHeaders(Map<String, String>  httpHeaders) {
        System.out.println("Headers" + httpHeaders);
        var aopHeader = httpHeaders.get("AOP-IS-AWESOME".toLowerCase());
        if(aopHeader == null || !aopHeader.equals("yes")){
            throw new RuntimeException("AOP-IS-AWESOME header is missing");
        }
    }


}
