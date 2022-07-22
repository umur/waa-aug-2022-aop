package edu.miu.waaaug2022aop.service;

import edu.miu.waaaug2022aop.dto.CourseDto;
import edu.miu.waaaug2022aop.entity.Course;

import java.util.List;

public interface CourseService {
    Course createOne(CourseDto courseDto);
    Course getOne(int courseId);
    List<Course> getAll();
}
