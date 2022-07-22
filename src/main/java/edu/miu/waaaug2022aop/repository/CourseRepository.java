package edu.miu.waaaug2022aop.repository;

import edu.miu.waaaug2022aop.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
