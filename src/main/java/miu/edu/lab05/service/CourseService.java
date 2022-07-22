package miu.edu.lab05.service;

import miu.edu.lab05.models.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> getAll();
    Optional<Course> getById(Long id);
    Course save(Course course);
    void delete(Long id);
}
