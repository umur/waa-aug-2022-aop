package com.miu.edu.lab4springaop.controller;

import com.miu.edu.lab4springaop.dto.ProductDto;
import com.miu.edu.lab4springaop.service.ProductService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "product endpoint")
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    final private ProductService productService;

    @GetMapping("/filter-by-price-minimum")
    @ResponseBody
    public List<ProductDto> getAllByPriceMin(@RequestParam double price) {
        return productService.findByPriceMin(price);
    }

    @GetMapping("/filter-by-category-name-and-maximum-price")
    @ResponseBody
    public List<ProductDto> getAllByCatNameWithMaxPrice(@RequestParam String cat, @RequestParam double price) {
        return productService.findByCatNameWithMaxPrice(cat, price);
    }

    @GetMapping("/filter-by-product-name")
    @ResponseBody
    public List<ProductDto> getAllByName(@RequestParam String name) {
        return productService.findByName(name);
    }
}
