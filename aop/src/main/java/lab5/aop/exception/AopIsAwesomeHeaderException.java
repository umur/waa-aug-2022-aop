package lab5.aop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AopIsAwesomeHeaderException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public AopIsAwesomeHeaderException(String message) {
        super(message);
    }
}
