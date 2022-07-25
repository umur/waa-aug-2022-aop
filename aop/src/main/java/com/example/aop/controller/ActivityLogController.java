package com.example.aop.controller;

import com.example.aop.model.ActivityLog;
import com.example.aop.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/log")
public class ActivityLogController {
    private final ActivityLogService activityLogService;

    @GetMapping
    public List<ActivityLog> findAll(){
        return activityLogService.findAll();
    }

    @GetMapping("/{id}")
    public ActivityLog findById(@PathVariable("id") Long id){
        return activityLogService.findById(id);
    }
}
