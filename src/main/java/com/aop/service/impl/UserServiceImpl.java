package com.miu.aop.service.impl;

import com.miu.aop.helper.Helper;
import com.miu.aop.model.User;
import com.miu.aop.repository.UserRepository;
import com.miu.aop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private Helper helper;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll(){
        return userRepository.findAll();
    }
    @Override
    public Optional<User> getById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }
}
