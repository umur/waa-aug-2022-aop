package com.example.springdatademo.controller;

import com.example.springdatademo.dto.UserDto;
import com.example.springdatademo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @PostMapping
    public UserDto save(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }

    @PutMapping("/{id}")
    public UserDto update(@RequestBody UserDto userDto) {
        return userService.update(userDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userService.delete(id);
    }
}
