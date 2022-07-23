package cs545waa.lab5.controller;

import cs545waa.lab5.dto.AddressDto;
import cs545waa.lab5.service.AddressService;
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

    @PostMapping
    public AddressDto create(@RequestBody AddressDto addressDto) {
        return addressService.create(addressDto);
    }

    @DeleteMapping("/{addressId}")
    public void delete(@PathVariable int addressId) {
        addressService.delete(addressId);
    }
}
