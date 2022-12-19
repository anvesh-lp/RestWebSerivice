package com.example.restwebserivice.repositories;

import com.example.restwebserivice.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
