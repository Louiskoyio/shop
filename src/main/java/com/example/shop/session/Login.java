package com.example.shop.session;

import com.example.shop.dao.UserDao;
import com.example.shop.models.User;

import java.util.List;

public class Login {

    public User loginAttempt(String userEmail, String userPassword) {
        List<User> users;
        users = getMatchingUser(userEmail, userPassword);
        return users.isEmpty() ? null : users.get(0);
    }

    private List<User> getMatchingUser(String userEmail, String userPassword) {
        return new UserDao().getUsers(
                "SELECT * FROM Users WHERE email = '" + userEmail + "' AND password = '" + userPassword + "';");
    }
}
