package com.waa.lab5.service;

import com.waa.lab5.dto.ReviewDTO;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<ReviewDTO> findAll();

    Optional<ReviewDTO> findById(Integer id);

    void save(ReviewDTO reviewDTO);

    void deleteById(Integer id);

    List<ReviewDTO> findAllByProduct(Integer productId);
}
