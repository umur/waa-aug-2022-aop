package edu.miu.lab5.service.Impl;

import edu.miu.lab5.dto.ProductDto;
import edu.miu.lab5.entity.Category;
import edu.miu.lab5.entity.Product;
import edu.miu.lab5.helper.ExecutionTime;
import edu.miu.lab5.repository.CategoryRepository;
import edu.miu.lab5.repository.ProductRepository;
import edu.miu.lab5.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    private final ModelMapper modelMapper;

    @Override
    @ExecutionTime
    public Product save(ProductDto productDto) {
        Category category = categoryRepository.findById(productDto.getCategoryId()).orElse(null);

        Product product = modelMapper.map(productDto, Product.class);
        product.setCategory(category);

        return productRepository.save(product);
    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product getById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAllByPriceGreaterThan(double minCost) {
        return productRepository.findAllByPriceGreaterThan(minCost);
    }

    @Override
    public List<Product> findAllByPriceLessThanAndCategory(double maxPrice, int cat) {
        return productRepository.findAllByPriceLessThanAndCategoryId(maxPrice, cat);
    }

    @Override
    public List<Product> findByCategory(String keyword) {
        return productRepository.findByCategoryContaining(keyword);
    }
}
