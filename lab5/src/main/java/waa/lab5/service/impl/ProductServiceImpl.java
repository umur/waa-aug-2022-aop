package waa.lab5.service.impl;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import waa.lab5.dto.ProductDto;
import waa.lab5.entity.Product;
import waa.lab5.helper.ExecutionTime;
import waa.lab5.repository.ProductRepo;
import waa.lab5.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    private final ModelMapper modelMapper;

    @Override
    public List<ProductDto> findAll() {
        var result = new ArrayList<ProductDto>();
        productRepo.findAll().forEach(product -> result.add(modelMapper.map(product, ProductDto.class)));
        return result;
    }

    @Override
    public ProductDto findById(int id) {
        return modelMapper.map(productRepo.findById(id).get(), ProductDto.class);
    }

    @Override
    public void deleteById(int id) {
        productRepo.deleteById(id);
    }

    @Override
    @ExecutionTime
    public void saveProduct(ProductDto productDto) {
        productRepo.save(modelMapper.map(productDto, Product.class));
    }

    @Override
    public List<ProductDto> findAllByPriceGreaterThanEqual(double minPrice) {
        var result = new ArrayList<ProductDto>();
        productRepo.findAllByPriceGreaterThanEqual(minPrice).forEach(pro -> result.add(modelMapper.map(pro, ProductDto.class)));
        return result;
    }

    @Override
    public List<ProductDto> findAllByCategoryAndPriceLessThanEqual(int category, double maxPrice) {
        var result = new ArrayList<ProductDto>();
        productRepo.findAllByCategory_IdAndPriceLessThanEqual(category, maxPrice).forEach(pro -> result.add(modelMapper.map(pro, ProductDto.class)));
        return result;
    }

    @Override
    public List<ProductDto> findAllByNameContains(String keyWord) {
        var result = new ArrayList<ProductDto>();
        productRepo.findAllByNameContains(keyWord).forEach(pro -> result.add(modelMapper.map(pro, ProductDto.class)));
        return result;
    }

    @Override
    public List<ProductDto> findAllByPriceGreaterThanEqualJPQL(double minPrice) {
        var result = new ArrayList<ProductDto>();
        productRepo.findAllByPriceGreaterThanEqualJPQL(minPrice).forEach(pro -> result.add(modelMapper.map(pro, ProductDto.class)));
        return result;
    }

    @Override
    public List<ProductDto> findAllByCategoryAndPriceLessThanEqualJPQL(int category, double maxPrice) {
        var result = new ArrayList<ProductDto>();
        productRepo.findAllByCategoryAndPriceLessThanEqualJPQL(category, maxPrice).forEach(pro -> result.add(modelMapper.map(pro, ProductDto.class)));
        return result;
    }

    @Override
    public List<ProductDto> findAllByNameContainsJPQL(String keyWord) {
        var result = new ArrayList<ProductDto>();
        productRepo.findAllByNameContainsJPQL(keyWord).forEach(pro -> result.add(modelMapper.map(pro, ProductDto.class)));
        return result;
    }
}
