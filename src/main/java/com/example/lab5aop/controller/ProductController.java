package com.example.lab5aop.controller;


import com.example.lab5aop.domain.Product;
import com.example.lab5aop.dto.ProductDTO;
import com.example.lab5aop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    ProductService productService;


    @GetMapping
    List<ProductDTO> findAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    ProductDTO findProductById(@PathVariable int id){
        return productService.findById(id);
    }

    @PostMapping
    Product addProduct(@RequestBody ProductDTO productDTO){
        return productService.addProduct(productDTO);
    }

    @PutMapping
    Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }


}
