package com.example.lab5aop.service;


import com.example.lab5aop.domain.Product;
import com.example.lab5aop.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAll();
    List<ProductDTO> findAllProductsPriceGreaterThan(Double price);
    List<ProductDTO> findAllProductsPriceLessThan(Double price);
    ProductDTO findById(int id);
    Product addProduct(ProductDTO productDto);
    Product updateProduct(Product product);
    void deleteById(int id);
}
