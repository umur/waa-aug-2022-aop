package com.miu.edu.lab4springaop.service.imp;

import com.miu.edu.lab4springaop.dto.ProductDto;
import com.miu.edu.lab4springaop.entity.Product;
import com.miu.edu.lab4springaop.repository.ProductRepository;
import com.miu.edu.lab4springaop.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Component
@AllArgsConstructor
public class ProductServiceImp implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ProductDto> findByPriceMin(double price) {
        List<Product> products = new ArrayList<>();
        products.addAll(productRepository.findAllByPriceGreaterThan(price));
        return products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> findByCatNameWithMaxPrice(String cat, double price) {
        List<Product> products = new ArrayList<>();
        productRepository.findAllByCategory_NameAndPriceLessThan(cat, price).forEach(products::add);
        return products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> findByName(String name) {
        List<Product> products = new ArrayList<>();
        productRepository.findAllByNameContainsIgnoreCase(name).forEach(products::add);
        return products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }
}
