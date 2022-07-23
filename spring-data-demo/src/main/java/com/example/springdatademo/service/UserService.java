package com.example.springdatademo.service;

import com.example.springdatademo.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();
    UserDto save(UserDto userDto);
    UserDto findById(int userId);
    UserDto update(UserDto userDto);
    void delete(int id);
}
