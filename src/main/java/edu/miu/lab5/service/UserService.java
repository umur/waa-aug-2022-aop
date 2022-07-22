package edu.miu.lab5.service;

import edu.miu.lab5.dto.ReviewDto;
import edu.miu.lab5.dto.UserDto;
import edu.miu.lab5.entity.User;

import java.util.List;

public interface UserService {
    User save(UserDto userDto);

    void delete(int id);

    User getById(int id);

    List<User> getAll();

    User updateUser(User user);

    ReviewDto createUserReview(ReviewDto reviewDto);
}
