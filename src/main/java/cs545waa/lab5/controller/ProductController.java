package cs545waa.lab5.controller;

import cs545waa.lab5.dto.ProductDto;
import cs545waa.lab5.helper.ExecutionTime;
import cs545waa.lab5.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    @ExecutionTime
    public List<ProductDto> findAll(@RequestParam (required = false) String minPrice) {
        if (minPrice != null && !minPrice.isEmpty()) {
            return productService.findAllByPriceGreaterThan(Double.parseDouble(minPrice));
        }
        return productService.findAll();
    }

    @GetMapping("/filter-by-category-max-price")
    public List<ProductDto> findAllByCategoryAndMaxPrice(@RequestParam String category, @RequestParam String maxPrice) {
        return productService.findAllByCategoryAndMaxPrice(category, Double.parseDouble(maxPrice));
    }

    @GetMapping("/filter-by-keyword")
    public List<ProductDto> findByKeyword(@RequestParam String keyword) {
        return productService.findByKeyword(keyword);
    }

}
