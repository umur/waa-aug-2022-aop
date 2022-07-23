package cs545waa.lab5.repository;

import cs545waa.lab5.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {
}
