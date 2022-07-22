package lab5.aop.controller;

import lab5.aop.service.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomeController {
    @Autowired
    private SomeService someService;

    @PostMapping
    public String someFunc(){
        return someService.someFunc();
    }

    @GetMapping
    public String someFunc2(){
        return someService.someFunc2();
    }
}
