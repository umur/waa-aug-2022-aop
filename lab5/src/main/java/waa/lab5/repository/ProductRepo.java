package waa.lab5.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import waa.lab5.entity.Product;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {

    List<Product> findAllByPriceGreaterThanEqual(double minPrice);

    List<Product> findAllByCategory_IdAndPriceLessThanEqual(int category, double maxPrice);

    List<Product> findAllByNameContains(String keyWord);

    @Query("Select p from Product p where p.price >= :price")
    List<Product> findAllByPriceGreaterThanEqualJPQL(@Param("price") double price);

    @Query("Select p from Product p where p.price <= :price and p.category.id = :category")
    List<Product> findAllByCategoryAndPriceLessThanEqualJPQL(@Param("category") int category, @Param("price") double price);

    @Query("Select p from Product p where p.name like %:name% ")
    List<Product> findAllByNameContainsJPQL(@Param("name") String name);
}
