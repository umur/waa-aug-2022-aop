package com.example.lab5.controller;

import com.example.lab5.aop.annotation.AwesomeCheck;
import com.example.lab5.aop.annotation.ExecutionTime;
import com.example.lab5.dto.LogDto;
import com.example.lab5.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MyController {

    @Autowired
    LogService logService;

    @ExecutionTime
    @GetMapping("/logs")
    public List<LogDto> getAllLogs() {
        return logService.getAllLogs();
    }

    @AwesomeCheck
    @PostMapping("/log")
    public LogDto createLog(@RequestBody LogDto logDto) {
        return logService.saveActivityLog(logDto);
    }


    /**
     * Make an Aspect that has an pointcut for classes in edu.miu.service
     *  package to check if POST requests has AOP-IS-AWESOME header.
     *  If the header is not present then throw a AopIsAwesomeHeaderException.
     */

}
