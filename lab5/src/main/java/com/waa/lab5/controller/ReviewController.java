package com.waa.lab5.controller;

import com.waa.lab5.aop.ExecutionTime;
import com.waa.lab5.dto.ReviewDTO;
import com.waa.lab5.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping
    List<ReviewDTO> findAll() {
        return reviewService.findAll();
    }

    @GetMapping("/{id}")
    Optional<ReviewDTO> findById(@PathVariable Integer id) {
        return reviewService.findById(id);
    }

    @PostMapping()
    void save(@RequestBody ReviewDTO reviewDTO) {
        reviewService.save(reviewDTO);
    }

    @PutMapping("/{id}")
    void update(@RequestBody ReviewDTO reviewDTO) {
        reviewService.save(reviewDTO);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Integer id) {
        reviewService.deleteById(id);
    }

    @GetMapping("/findByProduct")
    List<ReviewDTO> findByProduct(@RequestParam Integer productId) {
        return reviewService.findAllByProduct(productId);
    }
}
