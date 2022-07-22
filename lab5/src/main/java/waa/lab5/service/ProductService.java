package waa.lab5.service;

import waa.lab5.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> findAll();

    ProductDto findById(int id);

    void deleteById(int id);

    void saveProduct(ProductDto product);

    List<ProductDto> findAllByPriceGreaterThanEqual(double minPrice);

    List<ProductDto> findAllByCategoryAndPriceLessThanEqual(int category, double maxPrice);

    List<ProductDto> findAllByNameContains(String keyWord);

    List<ProductDto> findAllByPriceGreaterThanEqualJPQL(double minPrice);

    List<ProductDto> findAllByCategoryAndPriceLessThanEqualJPQL(int category, double maxPrice);

    List<ProductDto> findAllByNameContainsJPQL(String keyWord);
}
