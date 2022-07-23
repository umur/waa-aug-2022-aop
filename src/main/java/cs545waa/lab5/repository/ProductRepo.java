package cs545waa.lab5.repository;

import cs545waa.lab5.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepo extends CrudRepository<Product, Integer> {
    List<Product> findAllByPriceGreaterThan(double minPrice);

    @Query(value = "SELECT p FROM Product p JOIN p.category c WHERE p.price < ?2 AND c.name = ?1")
    List<Product> findAllByCategoryAndMaxPrice(String category, double maxPrice);

    @Query(value = "SELECT p FROM Product p WHERE p.name LIKE %?1%")
    List<Product> findAllByNameContaining(String keyWord);
}
