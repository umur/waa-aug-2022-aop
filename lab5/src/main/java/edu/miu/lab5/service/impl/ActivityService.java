package edu.miu.lab5.service.impl;

import edu.miu.lab5.entity.ActivityLog;
import edu.miu.lab5.repository.ActivityRepository;
import edu.miu.lab5.service.IActivityService;
import org.springframework.stereotype.Service;

@Service
public class ActivityService implements IActivityService {

    private ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public void save(ActivityLog log) {
        activityRepository.save(log);
    }
}
