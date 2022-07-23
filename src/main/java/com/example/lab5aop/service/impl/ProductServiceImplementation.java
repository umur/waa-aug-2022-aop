package com.example.lab5aop.service.impl;


import com.example.lab5aop.aop.ExecutionTime;
import com.example.lab5aop.domain.Product;
import com.example.lab5aop.dto.ProductDTO;
import com.example.lab5aop.repository.ProductRepository;
import com.example.lab5aop.service.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImplementation implements ProductService {

    ProductRepository productRepository;
    ModelMapper modelMapper;

    @ExecutionTime
    @Override
    public List<ProductDTO> findAll() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findAllProductsPriceGreaterThan(Double price) {
        List<Product> products = productRepository.findByPriceGreaterThan(price);
        return products.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    public List<ProductDTO> findAllProductsPriceLessThan(Double price) {
        List<Product> products = productRepository.findByPriceLessThan(price);
        return products.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO findById(int id) {
        Product product = productRepository.findProductById(id);
        return modelMapper.map(product, ProductDTO.class);
    }


    @Override
    public Product addProduct(ProductDTO productDto) {
        Product product = productRepository.save(modelMapper.map(productDto, Product.class));
        return product;
    }

    @Override
    public Product updateProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }
}

