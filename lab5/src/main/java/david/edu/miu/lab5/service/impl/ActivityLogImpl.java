package david.edu.miu.lab5.service.impl;

import david.edu.miu.lab5.entity.ActivityLog;
import david.edu.miu.lab5.helper.ExecutionTime;
import david.edu.miu.lab5.repo.ActivityLogRepo;
import david.edu.miu.lab5.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ActivityLogImpl implements ActivityLogService {

    @Autowired
    private final ActivityLogRepo activityLogRepo;


    @Override
    @ExecutionTime
    public List<ActivityLog> getAll() {
        var result= new ArrayList<ActivityLog>();
        activityLogRepo.findAll().forEach(result::add);
        return result;
    }

    @Override
    @ExecutionTime
    public void save(ActivityLog activityLog) {
        activityLogRepo.save(activityLog);
    }
}
