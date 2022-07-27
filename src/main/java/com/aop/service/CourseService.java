package com.miu.aop.service;

import com.miu.aop.model.Course;
import java.util.List;
import java.util.Optional;


public interface CourseService {
    public List<Course> getAll();
    Optional<Course> getById(int id);
    Course save(Course course);
    void delete(int id);

}
