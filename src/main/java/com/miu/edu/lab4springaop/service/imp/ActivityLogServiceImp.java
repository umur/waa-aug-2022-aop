package com.miu.edu.lab4springaop.service.imp;

import com.miu.edu.lab4springaop.annotation.ExecutionTime;
import com.miu.edu.lab4springaop.entity.ActivityLog;
import com.miu.edu.lab4springaop.repository.ActivityLogRepository;
import com.miu.edu.lab4springaop.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityLogServiceImp implements ActivityLogService {
    private final ActivityLogRepository activityLogRepository;

    @Override
    @ExecutionTime
    public void save(ActivityLog activityLog) {
        activityLogRepository.save(activityLog);
    }
}
