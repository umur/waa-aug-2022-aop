package com.miu.Lab5AOP.controller;

import com.miu.Lab5AOP.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping
    public ResponseEntity findAll(){
        demoService.doSomething();
        return  ResponseEntity.ok(HttpStatus.CREATED);
    }
    @PostMapping
    public ResponseEntity add(){
        return  ResponseEntity.ok(demoService.doSomething());
    }
}
