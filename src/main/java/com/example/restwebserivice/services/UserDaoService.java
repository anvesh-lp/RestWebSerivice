package com.example.restwebserivice.services;


import com.example.restwebserivice.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    public static List<User> usersList = new ArrayList<>();
    public static Integer userIds = 0;

    static {
        usersList.add(new User(++userIds, "Anvesh", LocalDate.now().minusYears(24)));
        usersList.add(new User(++userIds, "Vamshi", LocalDate.now().minusYears(24)));
        usersList.add(new User(++userIds, "Ganesh", LocalDate.now().minusYears(24)));
        usersList.add(new User(++userIds, "Kavya", LocalDate.now().minusYears(24)));
        usersList.add(new User(++userIds, "Mani", LocalDate.now().minusYears(24)));
        usersList.add(new User(++userIds, "Nandhan", LocalDate.now().minusYears(24)));
        usersList.add(new User(++userIds, "Neha", LocalDate.now().minusYears(24)));
    }

    public List<User> getUsersList() {
        return usersList;
    }

    public User getUserById(int id) {
        return usersList.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    public User saveUser(User user) {
        ++userIds;
        user.setId(userIds);
        usersList.add(user);
        return user;
    }

    public void deleteUser(int id) {
        usersList.removeIf(user -> user.getId() == id);
    }

}
