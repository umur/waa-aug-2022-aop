package com.miu.edu.lab4springaop.controller;

import com.miu.edu.lab4springaop.dto.ReviewDto;
import com.miu.edu.lab4springaop.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("review")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/{id}")
    @ResponseBody
    public List<ReviewDto> getAllByProductId(@PathVariable int id) {
        return reviewService.findAllByProductId(id);
    }
}
