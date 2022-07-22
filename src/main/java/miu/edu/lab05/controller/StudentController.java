package miu.edu.lab05.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.lab05.models.Student;
import miu.edu.lab05.service.StudentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentServiceImpl service;
    @GetMapping
    public List<Student> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getById(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public Student save(@RequestBody Student student) {
        return service.save(student);
    }

    @PutMapping("{id}")
    public Student save(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        return service.save(student);
    }

    @DeleteMapping("{id}")
    public void save(@PathVariable Long id) {
        service.delete(id);
    }
}
