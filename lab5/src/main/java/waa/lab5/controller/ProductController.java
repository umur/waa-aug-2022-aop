package waa.lab5.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import waa.lab5.dto.ProductDto;
import waa.lab5.service.ProductService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductDto> findAll() {
        return productService.findAll();
    }

    @PostMapping
    public void addCategory(@RequestBody ProductDto productDto) {
        productService.saveProduct(productDto);
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable int id) {
        return productService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        productService.deleteById(id);
    }

    @GetMapping("/findByPrice")
    public List<ProductDto> findAllByPriceGreaterThanEqual(@RequestParam int price) {
        return productService.findAllByPriceGreaterThanEqual(price);
    }

    @GetMapping("/findByCategoryAndPrice")
    public List<ProductDto> findAllByCategoryAndPriceLessThanEqual(@PathVariable int category, @PathVariable double price) {
        return productService.findAllByCategoryAndPriceLessThanEqual(category, price);
    }

    @GetMapping("/name/{name}")
    public List<ProductDto> findAllByNameContains(@PathVariable String name) {
        return productService.findAllByNameContains(name);
    }

    @GetMapping("/JPQL/price/{price}")
    public List<ProductDto> findAllByPriceGreaterThanEqualJPQL(@PathVariable int price) {
        return productService.findAllByPriceGreaterThanEqualJPQL(price);
    }

    @GetMapping("/JPQL/category/{category}/price/{price}")
    public List<ProductDto> findAllByCategoryAndPriceLessThanEqualJPQL(@PathVariable int category, @PathVariable double price) {
        return productService.findAllByCategoryAndPriceLessThanEqualJPQL(category, price);
    }

    @GetMapping("/JPQL/name/{name}")
    public List<ProductDto> findAllByNameContainsJPQL(@PathVariable String name) {
        return productService.findAllByNameContainsJPQL(name);
    }
}
