package com.example.springdatademo.controller;

import com.example.springdatademo.dto.ReviewDto;
import com.example.springdatademo.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping
    public List<ReviewDto> findAll() {
        return reviewService.findAll();
    }

    @GetMapping("/{id}")
    public ReviewDto findById(@PathVariable Integer id) {
        return reviewService.findById(id);
    }

    @PostMapping
    public ReviewDto save(@RequestBody ReviewDto reviewDto) {
        return reviewService.save(reviewDto);
    }

    @PutMapping("/{id}")
    public ReviewDto update(@RequestBody ReviewDto reviewDto) {
        return reviewService.update(reviewDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        reviewService.delete(id);
    }
}
