package edu.miu.aop_lab.exception;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.OK, reason = "AOP is awesome in header.")
public class AopIsAwesomeException extends RuntimeException{

}
