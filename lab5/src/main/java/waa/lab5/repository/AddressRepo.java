package waa.lab5.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import waa.lab5.entity.Address;

@Repository
public interface AddressRepo extends CrudRepository<Address, Integer> {
}
