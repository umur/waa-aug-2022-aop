package com.example.springdatademo.service.impl;

import com.example.springdatademo.dto.ReviewDto;
import com.example.springdatademo.entity.Review;
import com.example.springdatademo.annotation.ExecutionTime;
import com.example.springdatademo.repository.ReviewRepository;
import com.example.springdatademo.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final ModelMapper modelMapper;

    @ExecutionTime
    @Override
    public List<ReviewDto> findAll() {
        return reviewRepository.findAll().stream().map(review -> reviewToDto(review)).collect(Collectors.toList());
    }
    @ExecutionTime
    @Override
    public ReviewDto save(ReviewDto reviewDto) {
        return reviewToDto(reviewRepository.save(dtoToReview(reviewDto)));
    }
    @ExecutionTime
    @Override
    public ReviewDto findById(int reviewId) {
        return reviewToDto(reviewRepository.findById(reviewId).orElse(null));
    }
    @ExecutionTime
    @Override
    public ReviewDto update(ReviewDto reviewDto) {
        return reviewToDto(reviewRepository.save(dtoToReview(reviewDto)));
    }
    @ExecutionTime
    @Override
    public void delete(int id) {
        reviewRepository.deleteById(id);
    }

    private ReviewDto reviewToDto(Review review) {
        return modelMapper.map(review, ReviewDto.class);
    }

    private Review dtoToReview(ReviewDto reviewDto) {
        return modelMapper.map(reviewDto, Review.class);
    }
}
