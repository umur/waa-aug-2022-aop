package waa.lab5.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import waa.lab5.dto.ReviewDto;
import waa.lab5.service.ReviewService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping
    public List<ReviewDto> findAll() {
        return reviewService.findAll();
    }

    @PostMapping
    public void add(@RequestBody ReviewDto ReviewDto) {
        reviewService.saveReview(ReviewDto);
    }

    @GetMapping("/{id}")
    public ReviewDto findById(@PathVariable int id) {
        return reviewService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        reviewService.deleteById(id);
    }
}
