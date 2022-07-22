package com.waa.lab5.service.impl;

import com.waa.lab5.aop.ExecutionTime;
import com.waa.lab5.dto.ReviewDTO;
import com.waa.lab5.entity.Review;
import com.waa.lab5.repository.ReviewRepository;
import com.waa.lab5.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ModelMapper modelMapper;
    private final ReviewRepository reviewRepository;

    @ExecutionTime
    @Override
    public List<ReviewDTO> findAll() {
        var result = new ArrayList<ReviewDTO>();
        reviewRepository.findAll().forEach(item -> {
            result.add(modelMapper.map(item, ReviewDTO.class));
        });
        return result;
    }

    @Override
    public Optional<ReviewDTO> findById(Integer id) {
        return reviewRepository.findById(id).map(item -> modelMapper.map(item, ReviewDTO.class));
    }

    @Override
    public void save(ReviewDTO reviewDTO) {
        reviewRepository.save(modelMapper.map(reviewDTO, Review.class));
    }

    @Override
    public void deleteById(Integer id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public List<ReviewDTO> findAllByProduct(Integer productId){
        return reviewRepository.findAllByProductId(productId)
                .stream()
                .map(item -> modelMapper.map(item, ReviewDTO.class))
                .collect(Collectors.toList());
    }
}
