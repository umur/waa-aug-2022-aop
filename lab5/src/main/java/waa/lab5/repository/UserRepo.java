package waa.lab5.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import waa.lab5.entity.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
}
