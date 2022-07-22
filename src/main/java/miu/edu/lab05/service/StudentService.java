package miu.edu.lab05.service;


import miu.edu.lab05.models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAll();
    Optional<Student> getById(Long id);
    Student save(Student student);
    void delete(Long id);
}
