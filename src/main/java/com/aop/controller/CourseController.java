package com.miu.aop.controller;

import com.miu.aop.model.Course;
import com.miu.aop.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {
    @Autowired
    private CourseService courseService;
    @GetMapping
    public List<Course> findAll(){
        return courseService.getAll();
    }
}
