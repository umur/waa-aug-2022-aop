package com.miu.edu.lab4springaop.repository;

import com.miu.edu.lab4springaop.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findAllByPriceGreaterThan(double price);
    List<Product> findAllByCategory_NameAndPriceLessThan(String name, double price);
    List<Product> findAllByNameContainsIgnoreCase(String name);
}
