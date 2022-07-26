package com.javokhir.lab5.controller;

import com.javokhir.lab5.service.WelcomeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/welcome")
public class WelcomeController {

    private final WelcomeService service;

    @PostMapping
    public String postAwesomeWelcome(){
        return service.makeAwesomeWelcoming();
    }

    @GetMapping
    public String getAwesomeWelcome(){
        return service.makeAwesomeWelcoming();
    }
}
