package edu.miu.lab5springaop.service.impl;

import edu.miu.lab5springaop.helper.ExecutionTime;
import edu.miu.lab5springaop.helper.HelloWorld;
import edu.miu.lab5springaop.helper.Helper;
import edu.miu.lab5springaop.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private Helper helper;

    @ExecutionTime
    @HelloWorld
    @Override
    public String findAll() {
        return "All courses";
    }
}
