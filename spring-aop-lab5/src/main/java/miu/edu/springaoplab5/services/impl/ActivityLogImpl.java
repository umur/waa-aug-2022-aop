package miu.edu.springaoplab5.services.impl;

import lombok.AllArgsConstructor;
import miu.edu.springaoplab5.models.ActivityLog;
import miu.edu.springaoplab5.repos.ActivityLogRepo;
import miu.edu.springaoplab5.services.ActivityLogService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ActivityLogImpl implements ActivityLogService {

    private final ActivityLogRepo activityLogRepo;

    @Override
    public void save(ActivityLog activityLog) {
        activityLogRepo.save(activityLog);
    }
}
