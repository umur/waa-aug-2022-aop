package miu.edu.springdata.repository;

import miu.edu.springdata.entity.Category;
import miu.edu.springdata.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findAllByPriceGreaterThan(double minPrice);

    List<Product> findAllByCategory_NameAndPriceLessThan(String catName, double maxPrice);

    List<Product> findAllByNameContainsIgnoreCase(String keyword);


}
