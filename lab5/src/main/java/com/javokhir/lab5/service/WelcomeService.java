package com.javokhir.lab5.service;

import com.javokhir.lab5.annotation.ExecutionTime;
import org.springframework.stereotype.Component;

@Component
public class WelcomeService {

    @ExecutionTime
    public String makeAwesomeWelcoming() {
        return "Hello my dear user and welcome to our wonderful application";
    }
}
