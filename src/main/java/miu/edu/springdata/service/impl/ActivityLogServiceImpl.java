package miu.edu.springdata.service.impl;

import miu.edu.springdata.entity.ActivityLog;
import miu.edu.springdata.repository.ActivityLogRepository;
import miu.edu.springdata.service.ActivityLogService;
import org.springframework.stereotype.Service;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {

    private final ActivityLogRepository activityLogRepository;

    public ActivityLogServiceImpl(ActivityLogRepository activityLogRepository) {
        this.activityLogRepository = activityLogRepository;
    }

    @Override
    public void saveLog(ActivityLog activityLog) {
        activityLogRepository.save(activityLog);
    }
}
