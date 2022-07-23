package com.example.lab5aop.service.impl;


import com.example.lab5aop.aop.ExecutionTime;
import com.example.lab5aop.domain.User;
import com.example.lab5aop.dto.UserDTO;
import com.example.lab5aop.repository.UserRepository;
import com.example.lab5aop.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserService {

    UserRepository userRepository;

    ModelMapper modelMapper;

    @ExecutionTime
    @Override
    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }


    @ExecutionTime
    @Override
    public User addUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        userRepository.save(user);
        return  user;
    }

    @ExecutionTime
    @Override
    public UserDTO findById(int id) {
        Optional<User> user = userRepository.findById(id);
        return modelMapper.map(user, UserDTO.class);
    }

    @ExecutionTime
    @Override
    public User update(User user) {
        userRepository.save(user);
        return user;
    }

    @ExecutionTime
    @Override
    public UserDTO deleteById(int id) {
        Optional<User> user = userRepository.findById(id);
        userRepository.deleteById(id);
        return  modelMapper.map(user, UserDTO.class);
    }
}
