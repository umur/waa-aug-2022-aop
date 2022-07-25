package com.example.aop.controller;

import com.example.aop.model.Product;
import com.example.aop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") Long id) {
        return productService.findById(id);
    }

    @PostMapping()
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        productService.delete(id);
    }
}
