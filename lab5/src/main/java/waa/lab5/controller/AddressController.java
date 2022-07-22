package waa.lab5.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import waa.lab5.dto.AddressDto;
import waa.lab5.service.AddressService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/addresses")
public class AddressController {
    private final AddressService addressService;

    @GetMapping
    public List<AddressDto> findAll() {
        return addressService.findAll();
    }

    @PostMapping
    public void addAddress(@RequestBody AddressDto address) {
        addressService.saveAddress(address);
    }

    @GetMapping("/{id}")
    public AddressDto findById(@PathVariable int id) {
        return addressService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        addressService.deleteById(id);
    }
}
