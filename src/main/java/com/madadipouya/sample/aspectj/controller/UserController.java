package com.madadipouya.sample.aspectj.controller;

import com.madadipouya.sample.aspectj.dto.User;
import com.madadipouya.sample.aspectj.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return getUsersInternal();
    }

    private List<User> getUsersInternal() {
        return userService.getAllUsers();
    }
}
