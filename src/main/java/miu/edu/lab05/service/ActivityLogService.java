package miu.edu.lab05.service;

import miu.edu.lab05.models.ActivityLog;

import java.util.List;
import java.util.Optional;

public interface ActivityLogService {
    List<ActivityLog> getAll();
    Optional<ActivityLog> getById(Long id);
    ActivityLog save(ActivityLog activityLog);
    void delete(Long id);
}
