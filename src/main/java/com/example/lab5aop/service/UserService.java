package com.example.lab5aop.service;


import com.example.lab5aop.domain.User;
import com.example.lab5aop.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> findAll();
    User addUser(UserDTO userDTO);
    UserDTO findById(int id);
    User update(User user);
    UserDTO deleteById(int id);
}
