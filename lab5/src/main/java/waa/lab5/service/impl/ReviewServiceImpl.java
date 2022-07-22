package waa.lab5.service.impl;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import waa.lab5.dto.ReviewDto;
import waa.lab5.entity.Review;
import waa.lab5.helper.ExecutionTime;
import waa.lab5.repository.ReviewRepo;
import waa.lab5.service.ReviewService;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepo reviewRepo;

    private final ModelMapper modelMapper;

    @Override
    public List<ReviewDto> findAll() {
        var result = new ArrayList<ReviewDto>();
        reviewRepo.findAll().forEach(review -> result.add(modelMapper.map(review, ReviewDto.class)));
        return result;
    }

    @Override
    public ReviewDto findById(int id) {
        return modelMapper.map(reviewRepo.findById(id).get(), ReviewDto.class);
    }

    @Override
    public void deleteById(int id) {
        reviewRepo.deleteById(id);
    }

    @Override
    @ExecutionTime
    public void saveReview(ReviewDto reviewDto) {
        reviewRepo.save(modelMapper.map(reviewDto, Review.class));
    }
}
