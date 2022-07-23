package cs545waa.lab5.repository;

import cs545waa.lab5.entity.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepo extends CrudRepository<Address, Integer> {
}
