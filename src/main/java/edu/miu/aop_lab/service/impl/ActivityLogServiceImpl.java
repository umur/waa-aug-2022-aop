package edu.miu.aop_lab.service.impl;

import edu.miu.aop_lab.dto.ActivityLogDto;
import edu.miu.aop_lab.entity.ActivityLog;
import edu.miu.aop_lab.repository.ActivityLogRepository;
import edu.miu.aop_lab.service.ActivityLogService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService {

    private final ActivityLogRepository activityLogrepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public ActivityLogDto addActivityLog(ActivityLogDto activityLogDto) {
        ActivityLog activitylog = modelMapper.map(activityLogDto , ActivityLog.class);
        ActivityLog al = activityLogrepository.save(activitylog);
        return modelMapper.map(al , ActivityLogDto.class);
    }

}
