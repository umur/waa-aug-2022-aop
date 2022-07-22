package com.waa.lab5.service.impl;

import com.waa.lab5.dto.ActivityLogDTO;
import com.waa.lab5.entity.ActivityLog;
import com.waa.lab5.repository.ActivityLogRepository;
import com.waa.lab5.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService {
    private final ModelMapper modelMapper;
    private final ActivityLogRepository activityLogRepository;

    @Override
    public List<ActivityLogDTO> findAll() {
        var result = new ArrayList<ActivityLogDTO>();
        activityLogRepository.findAll().forEach(item -> {
            result.add(modelMapper.map(item, ActivityLogDTO.class));
        });
        return result;
    }

    @Override
    public Optional<ActivityLogDTO> findById(Integer id) {
        return activityLogRepository.findById(id).map(item -> modelMapper.map(item, ActivityLogDTO.class));
    }

    @Override
    public void save(ActivityLogDTO activityLogDTO) {
        activityLogRepository.save(modelMapper.map(activityLogDTO, ActivityLog.class));
    }

    @Override
    public void deleteById(Integer id) {
        activityLogRepository.deleteById(id);
    }
}
