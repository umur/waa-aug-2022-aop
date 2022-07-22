package lab5.aop.service;

import org.springframework.stereotype.Service;

@Service
public class SomeService {
    public String someFunc() {
        return "done Post";
    }

    public String someFunc2() {
        return "done Get";
    }
}
