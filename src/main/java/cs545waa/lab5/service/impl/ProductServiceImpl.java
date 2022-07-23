package cs545waa.lab5.service.impl;

import cs545waa.lab5.dto.ProductDto;
import cs545waa.lab5.repository.ProductRepo;
import cs545waa.lab5.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ProductRepo productRepo;

    @Autowired
    private final ModelMapper modelMapper;

    public List<ProductDto> findAll() {
        return StreamSupport
                .stream(productRepo.findAll().spliterator(), false)
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    public List<ProductDto> findAllByPriceGreaterThan(double minPrice) {
        return productRepo.findAllByPriceGreaterThan(minPrice).stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    public List<ProductDto> findAllByCategoryAndMaxPrice(String category, double maxPrice) {
        return productRepo.findAllByCategoryAndMaxPrice(category, maxPrice).stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    public List<ProductDto> findByKeyword(String keyWord) {
        return productRepo.findAllByNameContaining(keyWord).stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

}
