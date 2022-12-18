package com.example.restwebserivice.controllers;


import com.example.restwebserivice.model.User;
import com.example.restwebserivice.services.UserDaoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private UserDaoService userService;

    public UserController(UserDaoService userServie) {
        this.userService = userServie;
    }

    @GetMapping(path = "/users")
    public List<User> findAll() {
        return userService.getUsersList();
    }
}
