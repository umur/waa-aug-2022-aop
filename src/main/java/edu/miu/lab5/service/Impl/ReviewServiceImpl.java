package edu.miu.lab5.service.Impl;

import edu.miu.lab5.dto.ReviewDto;
import edu.miu.lab5.entity.Review;
import edu.miu.lab5.helper.ExecutionTime;
import edu.miu.lab5.repository.ReviewRepository;
import edu.miu.lab5.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    private final ModelMapper modelMapper;

    @Override
    @ExecutionTime
    public Review save(ReviewDto reviewDto) {
        Review review = modelMapper.map(reviewDto, Review.class);
        return reviewRepository.save(review);
    }

    @Override
    public void delete(int id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public Review getById(int id) {
        return reviewRepository.findById(id).orElse(null);
    }

    @Override
    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review updateReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<ReviewDto> findAllReviewsByProductId(int id) {
        List<Review> reviews = reviewRepository.findAllByProductId(id);
        List<ReviewDto> reviewDtos = new ArrayList<>();

        for(Review review: reviews) {
            ReviewDto reviewDto = modelMapper.map(review, ReviewDto.class);
            reviewDto.setUserId(review.getUser().getId());
            reviewDto.setProductId(review.getProduct().getId());
            reviewDtos.add(reviewDto);
        }
        return reviewDtos;
    }
}
