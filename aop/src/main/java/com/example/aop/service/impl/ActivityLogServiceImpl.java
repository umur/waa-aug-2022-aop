package com.example.aop.service.impl;

import com.example.aop.annotation.ExecutionTime;
import com.example.aop.model.ActivityLog;
import com.example.aop.repository.ActivityLogRepository;
import com.example.aop.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService {
    private final ActivityLogRepository activityLogRepository;

    @Override
    public List<ActivityLog> findAll() {
        return activityLogRepository.findAll();
    }

    @Override
    @ExecutionTime
    public ActivityLog findById(Long id) {
        return activityLogRepository.findById(id).orElse(null);
    }

    @Override
    public ActivityLog save(ActivityLog activityLog) {
        return activityLogRepository.save(activityLog);
    }
}
