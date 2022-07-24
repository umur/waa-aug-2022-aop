package com.example.lab5.service;

import com.example.lab5.dto.LogDto;
import com.example.lab5.entity.ActivityLog;
import com.example.lab5.respository.LogRepo;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogService {

    @Autowired
    LogRepo logRepo;

    @Autowired
    ModelMapper modelMapper;

    public List<LogDto> getAllLogs() {
        List<ActivityLog> activityLogs = logRepo.findAll();
        List<LogDto> logDtos = new ArrayList<>();
        for(ActivityLog activityLog: activityLogs) {
            LogDto logDto = modelMapper.map(activityLog, LogDto.class);
            logDtos.add(logDto);
        }
        return  logDtos;
    }

    public LogDto saveActivityLog(LogDto logDto) {
        ActivityLog log = modelMapper.map(logDto, ActivityLog.class);
        ActivityLog savedLog = logRepo.save(log);
        return modelMapper.map(savedLog, LogDto.class);
    }

}
