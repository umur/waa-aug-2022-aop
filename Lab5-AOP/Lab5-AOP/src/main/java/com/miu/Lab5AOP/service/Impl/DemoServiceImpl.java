package com.miu.Lab5AOP.service.Impl;

import com.miu.Lab5AOP.ExecutionTime;
import com.miu.Lab5AOP.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {


    @Override
    public String doSomething() {
        System.out.println("here");
        return "Hello";
    }
}
