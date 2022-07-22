package miu.edu.lab05.service;

import lombok.RequiredArgsConstructor;
import miu.edu.lab05.models.Course;
import miu.edu.lab05.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{
    private final CourseRepository repository;
    @Override
    public List<Course> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Course> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Course save(Course course) {
        return repository.save(course);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
