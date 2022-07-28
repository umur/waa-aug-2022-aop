package com.miu.edu.lab4springaop.controller;

import com.miu.edu.lab4springaop.entity.ActivityLog;
import com.miu.edu.lab4springaop.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/aop")
public class AopController {
    private final ActivityLogService activityLogService;

    @GetMapping
    void save(@RequestBody ActivityLog activityLog) {
        activityLogService.save(activityLog);
    }
}
