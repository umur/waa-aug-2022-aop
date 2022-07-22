package edu.miu.lab5.controller;

import edu.miu.lab5.dto.AddressDto;
import edu.miu.lab5.entity.Address;
import edu.miu.lab5.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController (AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public Address save(@RequestBody AddressDto addressDto) {
        return addressService.save(addressDto);
    }

    @GetMapping
    public List<Address> getAll() {
        return addressService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getById(@PathVariable int id) {
        var address = addressService.getById(id);
        return ResponseEntity.ok(address);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        addressService.delete(id);
    }

    @PutMapping
    public Address update(@RequestBody Address address) {
        return addressService.updateAddress(address);
    }
}
