package com.miu.edu.lab4springaop.service;

import com.miu.edu.lab4springaop.entity.ActivityLog;
import org.springframework.stereotype.Service;

@Service
public interface ActivityLogService {
    void save(ActivityLog activityLog);
}
