package cs545waa.lab5.service;

import cs545waa.lab5.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
    List<ReviewDto> findAll();
    List<ReviewDto> findByProductId(Integer productId);
}
