package edu.miu.aop_lab.service;

import edu.miu.aop_lab.dto.ActivityLogDto;
import edu.miu.aop_lab.entity.ActivityLog;

public interface ActivityLogService {

    ActivityLogDto addActivityLog(ActivityLogDto activityLogDto);
}
