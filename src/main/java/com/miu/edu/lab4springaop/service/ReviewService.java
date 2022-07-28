package com.miu.edu.lab4springaop.service;

import com.miu.edu.lab4springaop.dto.ReviewDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {
    List<ReviewDto> findAllByProductId(int id);
}
