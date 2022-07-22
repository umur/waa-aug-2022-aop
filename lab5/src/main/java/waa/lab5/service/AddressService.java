package waa.lab5.service;

import waa.lab5.dto.AddressDto;

import java.util.List;

public interface AddressService {

    List<AddressDto> findAll();

    AddressDto findById(int id);

    void deleteById(int id);

    void saveAddress(AddressDto add);
}
