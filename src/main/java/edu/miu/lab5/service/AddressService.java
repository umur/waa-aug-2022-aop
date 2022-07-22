package edu.miu.lab5.service;

import edu.miu.lab5.dto.AddressDto;
import edu.miu.lab5.entity.Address;

import java.util.List;

public interface AddressService {
    Address save(AddressDto addressDto);

    void delete(int id);

    Address getById(int id);

    List<Address> getAll();

    Address updateAddress(Address address);
}
