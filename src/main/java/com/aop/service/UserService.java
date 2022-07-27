package com.miu.aop.service;


import com.miu.aop.model.User;

import java.util.List;
import java.util.Optional;


public interface UserService {

     List<User> getAll();

     Optional<User> getById(int id);
     User save(User user);
    void delete(int id);

}
