package edu.miu.waaaug2022aop.controller;

import edu.miu.waaaug2022aop.dto.CourseDto;
import edu.miu.waaaug2022aop.entity.Course;
import edu.miu.waaaug2022aop.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public Course createCourse(@RequestBody CourseDto courseDto) {
        return courseService.createOne(courseDto);
    }

    @GetMapping(path = "/{id}")
    public Course getCourse(@PathVariable int id) {
        return courseService.getOne(id);
    }

    @GetMapping
    public List<Course> getCourses() {
        return  courseService.getAll();
    }
}
