package cs545waa.lab5.service.impl;

import cs545waa.lab5.dto.AddressDto;
import cs545waa.lab5.entity.Address;
import cs545waa.lab5.repository.AddressRepo;
import cs545waa.lab5.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    @Autowired
    private final AddressRepo addressRepo;

    @Autowired
    private final ModelMapper modelMapper;

    public List<AddressDto> findAll() {
        return StreamSupport
                .stream(addressRepo.findAll().spliterator(), false)
                .map(address -> modelMapper.map(address, AddressDto.class))
                .collect(Collectors.toList());
    }

    public AddressDto create(AddressDto addressDto) {
        return modelMapper.map(addressRepo.save(modelMapper.map(addressDto, Address.class)), AddressDto.class);
    }

    public void delete(int addressId) {
        addressRepo.deleteById(addressId);
    }
}
