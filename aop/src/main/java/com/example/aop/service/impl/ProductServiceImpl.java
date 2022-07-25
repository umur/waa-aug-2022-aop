package com.example.aop.service.impl;

import com.example.aop.annotation.ExecutionTime;
import com.example.aop.model.Product;
import com.example.aop.repository.ProductRepository;
import com.example.aop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    @ExecutionTime
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    @ExecutionTime
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    @ExecutionTime
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    @ExecutionTime
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
