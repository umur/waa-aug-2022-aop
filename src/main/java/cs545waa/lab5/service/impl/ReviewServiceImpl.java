package cs545waa.lab5.service.impl;

import cs545waa.lab5.dto.ReviewDto;
import cs545waa.lab5.repository.ReviewRepo;
import cs545waa.lab5.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private final ReviewRepo reviewRepo;

    @Autowired
    private final ModelMapper modelMapper;

    public List<ReviewDto> findAll() {
        return StreamSupport
                .stream(reviewRepo.findAll().spliterator(), false)
                .map(review -> modelMapper.map(review, ReviewDto.class))
                .collect(Collectors.toList());
    }

    public List<ReviewDto> findByProductId(Integer productId) {
        return reviewRepo.findAllByProductId(productId)
                .stream()
                .map(review -> modelMapper.map(review, ReviewDto.class))
                .collect(Collectors.toList());
    }
}
