package com.example.restwebserivice.controllers;


import com.example.restwebserivice.exeptions.UserNotFoundException;
import com.example.restwebserivice.model.Post;
import com.example.restwebserivice.model.User;
import com.example.restwebserivice.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {


    private final UserRepository userRepositoryImp;

    public UserController(UserRepository repo) {
        this.userRepositoryImp = repo;
    }

    @GetMapping(path = "/users")
    public List<User> findAll() {
//        return userService.getUsersList();
        return userRepositoryImp.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public User findOne(@PathVariable Integer id) {
//        User user = userService.getUserById(id);
        Optional<User> user = userRepositoryImp.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User Not found");
        }
        return user.get();
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
//        User savedUser = userService.saveUser(user);

        User savedUser = userRepositoryImp.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
//        userService.deleteUser(id);
        userRepositoryImp.deleteById(id);
    }

    @GetMapping("/users/{id}/posts")
    public List<Post> getPosts(@PathVariable int id) {
        Optional<User> user = userRepositoryImp.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User Not found");
        }
        return user.get().getPosts();
    }

}
