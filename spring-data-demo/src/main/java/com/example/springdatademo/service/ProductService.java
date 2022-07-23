package com.example.springdatademo.service;

import com.example.springdatademo.dto.ProductDto;
import com.example.springdatademo.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAll();

    List<ProductDto> findAllByPriceGreaterThan(double minPrice);

    List<ProductDto> findAllByCategoryAndPriceLessThan(int id, double minPrice);

    List<ProductDto> findAllByNameContaining(String keyword);
    ProductDto save(ProductDto productDto);

    ProductDto findById(int productId);

    ProductDto update(ProductDto productDto);

    void delete(int id);
}
