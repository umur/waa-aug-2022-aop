package cs545waa.lab5.controller;

import cs545waa.lab5.dto.ReviewDto;
import cs545waa.lab5.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public List<ReviewDto> findAll(@RequestParam (required = false) String minPrice) {
        return reviewService.findAll();
    }

    @GetMapping("/filter-by-product-id")
    public List<ReviewDto> findByProductId(@RequestParam (required = false) String productid) {
        return reviewService.findByProductId(Integer.parseInt(productid));
    }
}
