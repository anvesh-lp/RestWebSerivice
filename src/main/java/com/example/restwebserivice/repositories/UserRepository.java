package com.example.restwebserivice.repositories;

import com.example.restwebserivice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
