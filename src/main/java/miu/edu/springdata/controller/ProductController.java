package miu.edu.springdata.controller;

import miu.edu.springdata.dto.ProductDTO;
import miu.edu.springdata.dto.ReviewDTO;
import miu.edu.springdata.entity.ActivityLog;
import miu.edu.springdata.entity.Product;
import miu.edu.springdata.repository.ActivityLogRepository;
import miu.edu.springdata.repository.ProductRepository;
import miu.edu.springdata.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ProductRepository productRepository;
    private final ActivityLogRepository activityLogRepository;

    public ProductController(ProductService productService, ProductRepository productRepository, ActivityLogRepository activityLogRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
        this.activityLogRepository = activityLogRepository;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        List<Product> products = new ArrayList<>();

        productRepository.findAll().forEach(products::add);
        return products;
//        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable long id) {
        return productService.findById(id);
    }

        @GetMapping("/filterByMinPrice")
    public List<ProductDTO> getProductsWithMinPrice(@RequestParam double minPrice) {
        return productService.findWithMinPrice(minPrice);
    }

    @GetMapping("/filterByCat&MinPrice")
    public List<ProductDTO> getProductsWithMinPrice(@RequestParam String cat, @RequestParam double minPrice) {
        return productService.findByCatWithMaxPrice(cat, minPrice);
    }

    @GetMapping("/filterByKeyword")
    public List<ProductDTO> getByKeyword(@RequestParam String keyword) {
        return productService.findByKeyword(keyword);
    }

    @GetMapping("/{id}/reviews")
    public List<ReviewDTO> getReviews(@PathVariable long id) {
        return productService.findReviews(id);
    }

    @PostMapping("/{id}/reviews")
    public ReviewDTO addReview(@PathVariable long id, @RequestBody ReviewDTO reviewDTO) {
        return productService.addReview(id, reviewDTO);
    }

    @PostMapping
    public ProductDTO addProduct(@RequestBody ProductDTO productDTO) {
        return productService.addProduct(productDTO);
    }

    @GetMapping("/activity")
    public List<ActivityLog> getActivityLogs(){
        ArrayList<ActivityLog> list = new ArrayList<>();
        activityLogRepository.findAll().forEach(list::add);
        return list;
    }
}
