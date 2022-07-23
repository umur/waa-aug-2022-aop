package cs545waa.lab5.service.impl;

import cs545waa.lab5.entity.ActivityLog;
import cs545waa.lab5.repository.ActivityLogRepo;
import cs545waa.lab5.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService {

    private final ActivityLogRepo activityLogRepo;

    @Override
    public void create(ActivityLog activityLog) {
        activityLogRepo.save(activityLog);
    }
}
