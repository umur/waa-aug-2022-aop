package waa.lab5.service;

import waa.lab5.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto findById(int id);

    void deleteById(int id);

    void saveUser(UserDto user);
}
