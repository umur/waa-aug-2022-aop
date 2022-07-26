package edu.miu.lab5springaop.controller;

import edu.miu.lab5springaop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public String findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable int id) {
        return userService.findById(id);
    }

}
