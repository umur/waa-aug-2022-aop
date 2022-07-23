package com.miu.Lab5AOP.service.Impl;

import com.miu.Lab5AOP.entity.ActivityLog;
import com.miu.Lab5AOP.repository.ActivityLogRepo;
import com.miu.Lab5AOP.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService {

    private final ActivityLogRepo activityLogRepo;

    @Override
    public void save(ActivityLog activityLog) {
        activityLogRepo.save(activityLog);
    }
}
