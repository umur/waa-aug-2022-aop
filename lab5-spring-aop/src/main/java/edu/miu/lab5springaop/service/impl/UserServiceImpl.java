package edu.miu.lab5springaop.service.impl;

import edu.miu.lab5springaop.helper.ExecutionTime;
import edu.miu.lab5springaop.helper.HelloWorld;
import edu.miu.lab5springaop.helper.Helper;
import edu.miu.lab5springaop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private Helper helper;

    @Override
    public void save() {

    }

    @HelloWorld
    @ExecutionTime
    @Override
    public String findAll() {
        return "all users";
    }

    @ExecutionTime
    @Override
    public String findById(int id) {
        return "one user";
    }

    @Override
    public void update() {
    }

    @Override
    public void delete() {

    }
}
