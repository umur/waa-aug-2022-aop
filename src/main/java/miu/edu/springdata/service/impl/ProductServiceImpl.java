package miu.edu.springdata.service.impl;

import miu.edu.springdata.dto.ProductDTO;
import miu.edu.springdata.dto.ReviewDTO;
import miu.edu.springdata.entity.Product;
import miu.edu.springdata.entity.Review;
import miu.edu.springdata.repository.ProductRepository;
import miu.edu.springdata.repository.ReviewRepository;
import miu.edu.springdata.repository.UserRepository;
import miu.edu.springdata.service.ProductService;
import miu.edu.springdata.utils.AopIsAwesomeHeaderException;
import miu.edu.springdata.utils.ExecutionTime;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;



    public ProductServiceImpl(ProductRepository productRepository, ReviewRepository reviewRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductDTO> findAll() {
        List<Product> productList = new ArrayList<>();
        Iterable<Product> all = productRepository.findAll();
        System.out.println("productRepository.findAll() = " + all);
        all.forEach(productList::add);
        return productList
                .stream()
                .filter(product -> !product.isDeleted())
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO findById(long id) {
        List<Product> productList = new ArrayList<>();
        productRepository.findAll().forEach(productList::add);
        return productList
                .stream()
                .filter(product -> !product.isDeleted())
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No product with id: " + id));
    }

    @Override
    public List<ProductDTO> findWithMinPrice(double minPrice) {
        List<Product> productList = new ArrayList<>();
        productRepository.findAllByPriceGreaterThan(minPrice)
                .forEach(productList::add);

        return productList
                .stream()
                .filter(product -> !product.isDeleted())
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findByCatWithMaxPrice(String cat, double maxPrice) {
        List<Product> productList = new ArrayList<>();
        productRepository.findAllByCategory_NameAndPriceLessThan(cat, maxPrice)
                .forEach(productList::add);

        return productList
                .stream()
                .filter(product -> !product.isDeleted())
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findByKeyword(String keyword) {
        List<Product> productList = new ArrayList<>();
        productRepository.findAllByNameContainsIgnoreCase(keyword)
                .forEach(productList::add);

        return productList
                .stream()
                .filter(product -> !product.isDeleted())
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ReviewDTO> findReviews(long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new NoSuchElementException("No product with id:" + productId));
        return product.getReviews()
                .stream()
                .map(review -> modelMapper.map(review, ReviewDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ReviewDTO addReview(long productId, ReviewDTO reviewDTO) {
//        Product product = productRepository.findById(productId).orElseThrow(() -> new NoSuchElementException("No product with id:" + productId));
//        Review review = modelMapper.map(reviewDTO, Review.class);
//        review.setProduct(product);
//        return modelMapper.map(reviewRepository.save(review), ReviewDTO.class);
        return null;
    }

    @Override
    @ExecutionTime
    public ProductDTO addProduct(ProductDTO productDTO) {

        Product product = modelMapper.map(productDTO, Product.class);
        return modelMapper.map(productRepository.save(product), ProductDTO.class);
    }
}
