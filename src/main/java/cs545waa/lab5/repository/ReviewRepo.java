package cs545waa.lab5.repository;

import cs545waa.lab5.entity.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepo extends CrudRepository<Review, Integer> {
    @Query(value = "SELECT * FROM Review r WHERE r.product_id = ?1", nativeQuery = true)
    List<Review> findAllByProductId(Integer productId);
}
