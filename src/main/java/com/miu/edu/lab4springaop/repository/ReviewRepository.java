package com.miu.edu.lab4springaop.repository;

import com.miu.edu.lab4springaop.entity.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Integer> {
    List<Review> findAllByProductId(int id);
}
