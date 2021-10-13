package com.revature.services;

import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImpl;
import com.revature.models.User;

public class UserService {

    UserDAO userDAO = new UserDAOImpl();

    public boolean newUser(User user) {
        return userDAO.addUser(user);
    }
}
