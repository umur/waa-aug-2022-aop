package david.edu.miu.lab5.service;

import david.edu.miu.lab5.entity.ActivityLog;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ActivityLogService {

    List<ActivityLog> getAll();
    void save( ActivityLog activityLog);
}
