package com.revature.daos;

import com.revature.models.User;

import java.util.List;

public interface UserDAO {
    List<User> findAll();

    User findUser(String username);

    boolean addUser(User user);

    User loginUser(String username, String password);
}
