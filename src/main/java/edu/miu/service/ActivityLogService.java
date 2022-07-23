package edu.miu.service;

import edu.miu.entity.ActivityLog;

import java.util.List;

public interface ActivityLogService {
    void save(ActivityLog activityLog);

    List<ActivityLog> getAll();

    ActivityLog getById(Integer id);
}
