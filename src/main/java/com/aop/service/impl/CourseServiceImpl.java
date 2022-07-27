package com.miu.aop.service.impl;

import com.miu.aop.model.Course;
import com.miu.aop.repository.CourseRepository;
import com.miu.aop.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private CourseRepository courseRepository;
    @Override
    public List<Course> getAll(){
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> getById(int id){
        return courseRepository.findById(id);
    }

    @Override
    public Course save(Course course){
       return courseRepository.save(course);
    }

    @Override
    public void delete(int id){
         courseRepository.deleteById(id);
        System.out.println("Deleted");
    }
}
