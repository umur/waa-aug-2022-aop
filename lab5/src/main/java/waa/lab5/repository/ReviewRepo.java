package waa.lab5.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import waa.lab5.entity.Review;

@Repository
public interface ReviewRepo extends CrudRepository<Review, Integer> {
}
