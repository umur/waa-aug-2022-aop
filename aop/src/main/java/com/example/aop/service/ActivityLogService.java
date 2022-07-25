package com.example.aop.service;

import com.example.aop.model.ActivityLog;

import java.util.List;

public interface ActivityLogService {

    List<ActivityLog> findAll();

    ActivityLog findById(Long id);

    ActivityLog save(ActivityLog activityLog);
}
