package miu.edu.lab05.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.lab05.models.Course;
import miu.edu.lab05.service.CourseServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseServiceImpl service;
    @GetMapping
    public List<Course> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Course> getById(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public Course save(@RequestBody Course course) {
        return service.save(course);
    }

    @PutMapping("{id}")
    public Course save(@PathVariable Long id, @RequestBody Course course) {
        course.setId(id);
        return service.save(course);
    }

    @DeleteMapping("{id}")
    public void save(@PathVariable Long id) {
        service.delete(id);
    }
}
