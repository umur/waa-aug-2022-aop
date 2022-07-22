package edu.miu.lab5.service.Impl;

import edu.miu.lab5.dto.AddressDto;
import edu.miu.lab5.entity.Address;
import edu.miu.lab5.helper.ExecutionTime;
import edu.miu.lab5.repository.AddressRepository;
import edu.miu.lab5.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    private final ModelMapper modelMapper;

    @Override
    @ExecutionTime
    public Address save(AddressDto addressDto) {
        Address address = modelMapper.map(addressDto, Address.class);
        return addressRepository.save(address);
    }

    @Override
    public void delete(int id) {
        addressRepository.deleteById(id);
    }

    @Override
    public Address getById(int id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address updateAddress(Address address) {
        return addressRepository.save(address);
    }
}
