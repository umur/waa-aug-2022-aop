package com.waa.lab5.service;

import com.waa.lab5.dto.AddressDTO;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    List<AddressDTO> findAll();

    Optional<AddressDTO> findById(Integer id);

    void save(AddressDTO addressDTO);

    void deleteById(Integer id);
}
