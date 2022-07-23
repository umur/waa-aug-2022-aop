package com.example.springdatademo.service;

import com.example.springdatademo.dto.AddressDto;

import java.util.List;

public interface AddressService {
    List<AddressDto> findAll();
    AddressDto save(AddressDto addressDto);
    AddressDto findById(int addressId);
    AddressDto update(AddressDto addressDto);
    void delete(int id);
}
