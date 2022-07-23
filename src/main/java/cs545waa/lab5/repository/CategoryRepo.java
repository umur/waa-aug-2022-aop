package cs545waa.lab5.repository;

import cs545waa.lab5.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<Category, Integer> {
}
