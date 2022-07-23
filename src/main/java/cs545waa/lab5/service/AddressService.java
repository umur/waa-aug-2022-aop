package cs545waa.lab5.service;

import cs545waa.lab5.dto.AddressDto;

import java.util.List;

public interface AddressService {
    List<AddressDto> findAll();
    AddressDto create(AddressDto addressDto);
    void delete(int addressId);
}
