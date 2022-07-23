package cs545waa.lab5.service;

import cs545waa.lab5.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAll();
    List<ProductDto> findAllByPriceGreaterThan(double minPrice);
    List<ProductDto> findAllByCategoryAndMaxPrice(String category, double maxPrice);
    List<ProductDto> findByKeyword(String keyWord);
}
