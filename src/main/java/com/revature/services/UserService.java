package com.revature.services;

import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImpl;
import com.revature.models.User;

import java.util.List;

public class UserService {
    UserDAO userDAO = new UserDAOImpl();

    public boolean newUser(User user) {
        return userDAO.addUser(user);
    }

    public User loginUser(String username, String password) {
        return userDAO.loginUser(username, password);
    }

    public User findByUsername(String username) {
        return userDAO.findUser(username);
    }

    public List<User> getAllUsers() {
        return userDAO.findAll();
    }
}
