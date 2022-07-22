package waa.lab5.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import waa.lab5.entity.Category;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Integer> {
}
