package edu.miu.service.impl;

import edu.miu.entity.ActivityLog;
import edu.miu.repository.ActivityLogRepository;
import edu.miu.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService {
    private final ActivityLogRepository activityLogRepository;

    @Override
    public void save(ActivityLog activityLog) {
        activityLogRepository.save(activityLog);
    }

    @Override
    public List<ActivityLog> getAll() {
        return activityLogRepository.findAll();
    }

    @Override
    public ActivityLog getById(Integer id) {
        return activityLogRepository.findById(id).orElse(null);
    }
}
