package edu.miu.lab5.controller;

import edu.miu.lab5.exception.AopIsAwesomeHeaderException;
import edu.miu.lab5.service.ITestService;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    ITestService testService;

    public TestController(ITestService testService) {
        this.testService = testService;
    }

    @PostMapping
    public String Post()  {
       return new String("OK");
    }

    @GetMapping
    public void Get(){
        testService.Test();
    }
}
