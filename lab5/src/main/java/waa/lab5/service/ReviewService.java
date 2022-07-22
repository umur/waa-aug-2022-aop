package waa.lab5.service;

import waa.lab5.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
    List<ReviewDto> findAll();

    ReviewDto findById(int id);

    void deleteById(int id);

    void saveReview(ReviewDto review);
}
