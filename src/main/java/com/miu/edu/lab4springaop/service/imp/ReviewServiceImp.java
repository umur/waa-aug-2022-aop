package com.miu.edu.lab4springaop.service.imp;

import com.miu.edu.lab4springaop.dto.ReviewDto;
import com.miu.edu.lab4springaop.entity.Review;
import com.miu.edu.lab4springaop.repository.ReviewRepository;
import com.miu.edu.lab4springaop.service.ReviewService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Component
@AllArgsConstructor
public class ReviewServiceImp implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final ModelMapper modelMapper;

    public List<ReviewDto> findAllByProductId(int id) {
        List<Review> reviews = new ArrayList<>();
        reviews.addAll(reviewRepository.findAllByProductId(id));
        return reviews.stream()
                .map(review -> modelMapper.map(review, ReviewDto.class))
                .collect(Collectors.toList());
    }
}
