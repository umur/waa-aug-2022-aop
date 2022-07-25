package com.example.aop.service;

import com.example.aop.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(Long id);

    Product save(Product product);

    void delete(Long id);
}
