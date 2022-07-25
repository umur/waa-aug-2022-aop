package edu.miu.lab5.service.impl;

import edu.miu.lab5.anotation.ExecutionTime;
import edu.miu.lab5.service.ITestService;
import org.springframework.stereotype.Service;

@Service
public class TestService implements ITestService {

    @Override
    @ExecutionTime
    public void Test() {
        System.out.println("In Test");
        for (int i = 0; i < 100000; i++) {
            //Consume Time
        }

    }

    @Override
    public void Test2() {
        System.out.println("In Test 2");
        for (int i = 0; i < 100000; i++) {
            //Consume Time
        }

    }
}
