package com.example.springdatademo.service.impl;

import com.example.springdatademo.annotation.AwesomePost;
import com.example.springdatademo.dto.CategoryDto;
import com.example.springdatademo.dto.ProductDto;
import com.example.springdatademo.entity.Category;
import com.example.springdatademo.entity.Product;
import com.example.springdatademo.annotation.ExecutionTime;
import com.example.springdatademo.repository.CategoryRepository;
import com.example.springdatademo.repository.ProductRepository;
import com.example.springdatademo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    private final CategoryRepository categoryRepository;
    @ExecutionTime
    @AwesomePost
    @Override
    public List<ProductDto> findAll() {
        return productRepository.findAll().stream().map(product -> productToDto(product)).collect(Collectors.toList());
    }
    @ExecutionTime
    @Override
    public List<ProductDto> findAllByPriceGreaterThan(double minPrice) {
        return productRepository.findAllByPriceGreaterThan(minPrice).stream().map(product -> productToDto(product)).collect(Collectors.toList());
    }

    @ExecutionTime
    @Override
    public List<ProductDto> findAllByCategoryAndPriceLessThan(int id, double minPrice) {
        Optional<Category> category=categoryRepository.findById(id);
        if(!category.isPresent()){
            return Collections.emptyList();
        }
        return productRepository.findAllByCategoryAndPriceLessThan(category.get(),minPrice).stream().map(product -> productToDto(product)).collect(Collectors.toList());
    }
    @ExecutionTime
    @Override
    public List<ProductDto> findAllByNameContaining(String keyword) {
        return productRepository.findAllByNameContaining(keyword).stream().map(product -> productToDto(product)).collect(Collectors.toList());
    }

    @ExecutionTime
    @Override
    public ProductDto save(ProductDto productDto) {
        return productToDto(productRepository.save(dtoToProduct(productDto)));
    }

    @ExecutionTime
    @Override
    public ProductDto findById(int productId) {
        return productToDto(productRepository.findById(productId).orElse(null));
    }

    @ExecutionTime
    @Override
    public ProductDto update(ProductDto productDto) {
        Category category = modelMapper.map(productDto.getCategory(), Category.class);
        categoryRepository.save(category);
        return productToDto(productRepository.save(dtoToProduct(productDto)));
    }
    @ExecutionTime
    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }

    private ProductDto productToDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }

    private Product dtoToProduct(ProductDto productDto) {
        return modelMapper.map(productDto, Product.class);
    }
}
