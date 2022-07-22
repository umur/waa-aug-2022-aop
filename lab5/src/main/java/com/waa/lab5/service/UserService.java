package com.waa.lab5.service;

import com.waa.lab5.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> findAll();

    Optional<UserDTO> findById(Integer id);

    void save(UserDTO userDTO);

    void deleteById(Integer id);
}
