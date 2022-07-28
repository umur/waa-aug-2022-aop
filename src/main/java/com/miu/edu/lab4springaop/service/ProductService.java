package com.miu.edu.lab4springaop.service;

import com.miu.edu.lab4springaop.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<ProductDto> findByPriceMin(double price);
    List<ProductDto> findByCatNameWithMaxPrice(String cat, double price);
    List<ProductDto> findByName(String name);
}
