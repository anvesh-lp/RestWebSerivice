package com.example.restwebserivice.services;


import com.example.restwebserivice.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    public static List<User> usersList = new ArrayList<>();

    static {
        usersList.add(new User(1, "Anvesh", LocalDate.now().minusYears(24)));
        usersList.add(new User(2, "Vamshi", LocalDate.now().minusYears(24)));
        usersList.add(new User(3, "Ganesh", LocalDate.now().minusYears(24)));
        usersList.add(new User(4, "Kavya", LocalDate.now().minusYears(24)));
        usersList.add(new User(5, "Mani", LocalDate.now().minusYears(24)));
        usersList.add(new User(6, "Nandhan", LocalDate.now().minusYears(24)));
        usersList.add(new User(7, "Neha", LocalDate.now().minusYears(24)));
    }

    public List<User> getUsersList() {
        return usersList;
    }
}
