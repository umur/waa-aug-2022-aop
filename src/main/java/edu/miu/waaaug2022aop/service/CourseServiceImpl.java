package edu.miu.waaaug2022aop.service;

import edu.miu.waaaug2022aop.annotation.AwesomePost;
import edu.miu.waaaug2022aop.annotation.ExecutionTime;
import edu.miu.waaaug2022aop.dto.CourseDto;
import edu.miu.waaaug2022aop.entity.Course;
import edu.miu.waaaug2022aop.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final ModelMapper modelMapper;
    private final CourseRepository courseRepository;

    @Override
    @ExecutionTime
    @AwesomePost
    public Course createOne(CourseDto courseDto) {
        Course course = modelMapper.map(courseDto, Course.class);
        Course savedCourse = courseRepository.save(course);
        return savedCourse;
    }

    @Override
    @ExecutionTime
    public Course getOne(int courseId) {
        return courseRepository.findById(courseId).get();
    }

    @Override
    @ExecutionTime
    public List<Course> getAll() {
        return courseRepository.findAll();
    }
}
