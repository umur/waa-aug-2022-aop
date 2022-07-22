package com.waa.lab5.service.impl;

import com.waa.lab5.aop.ExecutionTime;
import com.waa.lab5.dto.UserDTO;
import com.waa.lab5.entity.User;
import com.waa.lab5.repository.UserRepository;
import com.waa.lab5.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @ExecutionTime
    @Override
    public List<UserDTO> findAll() {
        var result = new ArrayList<UserDTO>();
        userRepository.findAll().forEach(item -> {
            result.add(modelMapper.map(item, UserDTO.class));
        });
        return result;
    }

    @ExecutionTime
    @Override
    public Optional<UserDTO> findById(Integer id) {
        return userRepository.findById(id).map(item -> modelMapper.map(item, UserDTO.class));
    }

    @Override
    public void save(UserDTO userDTO) {
        userRepository.save(modelMapper.map(userDTO, User.class));
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }
}
