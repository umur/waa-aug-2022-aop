package edu.miu.lab5.service;

import edu.miu.lab5.dto.ReviewDto;
import edu.miu.lab5.entity.Review;

import java.util.List;

public interface ReviewService {
    Review save(ReviewDto reviewDto);

    void delete(int id);

    Review getById(int id);

    List<Review> getAll();

    Review updateReview(Review review);

    List<ReviewDto> findAllReviewsByProductId(int id);
}
