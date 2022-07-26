package edu.miu.lab5springaop.service;

public interface UserService {

    public void save();
    public String findAll();
    public String findById(int id);
    public void update();
    public void delete();
}
