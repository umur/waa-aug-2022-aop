package com.waa.lab5.service.impl;

import com.waa.lab5.aop.ExecutionTime;
import com.waa.lab5.dto.ProductDTO;
import com.waa.lab5.entity.Product;
import com.waa.lab5.repository.ProductRepository;
import com.waa.lab5.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @ExecutionTime
    @Override
    public List<ProductDTO> findAll() {
        var result = new ArrayList<ProductDTO>();
        productRepository.findAll().forEach(item -> {
            result.add(modelMapper.map(item, ProductDTO.class));
        });
        return result;
    }

    @Override
    public void save(ProductDTO productDTO) {
        productRepository.save(modelMapper.map(productDTO, Product.class));
    }

    @Override
    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<ProductDTO> findById(Integer id) {
        return productRepository.findById(id).map(item -> modelMapper.map(item, ProductDTO.class));
    }

    @Override
    public List<ProductDTO> findAllByPriceGreaterThanEqual(Integer minPrice) {
        return productRepository.findAllByPriceGreaterThanEqual(minPrice)
                .stream()
                .map(item -> modelMapper.map(item, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findAllByCategoryAndMaxPrice(Integer category, Integer maxPrice){
        return productRepository.findAllByCategoryIdAndPriceLessThanEqual(category, maxPrice)
                .stream()
                .map(item -> modelMapper.map(item, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findAllByNameIsLikeIgnoreCase(String keyword){
        return productRepository.findAllByNameContainingIgnoreCase( "%"+keyword+"%")
                .stream()
                .map(item -> modelMapper.map(item, ProductDTO.class))
                .collect(Collectors.toList());
    }
}
