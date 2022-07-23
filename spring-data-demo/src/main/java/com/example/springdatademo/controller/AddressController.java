package com.example.springdatademo.controller;

import com.example.springdatademo.dto.AddressDto;
import com.example.springdatademo.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping
    public List<AddressDto> findAll() {
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public AddressDto findById(@PathVariable Integer id) {
        return addressService.findById(id);
    }

    @PostMapping
    public AddressDto save(@RequestBody AddressDto addressDto) {
        return addressService.save(addressDto);
    }

    @PutMapping("/{id}")
    public AddressDto update(@RequestBody AddressDto addressDto) {
        return addressService.update(addressDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        addressService.delete(id);
    }
}
