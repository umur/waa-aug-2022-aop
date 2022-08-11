package david.edu.miu.lab5.controller;

import david.edu.miu.lab5.service.ActivityLogService;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ActivityLog")

public class ActivityLog {

private ActivityLogService activityLogService;

public  ActivityLog(ActivityLogService  activityLogService)
{
    this.activityLogService= activityLogService;
}

    @PostMapping
    public void save(){
    }
    @GetMapping
    public List<ActivityLog> getAll(){

    }
}
