package com.example.restwebserivice.controllers;


import com.example.restwebserivice.exeptions.UserNotFoundException;
import com.example.restwebserivice.model.User;
import com.example.restwebserivice.services.UserDaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping(path = "/users/{id}")
    public User findOne(@PathVariable Integer id) {
        User user = userService.getUserById(id);
        if (user == null) {
            throw new UserNotFoundException("User Not found");
        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userService.saveUser(user);

        System.out.println(userService.getUsersList().size());
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

}
