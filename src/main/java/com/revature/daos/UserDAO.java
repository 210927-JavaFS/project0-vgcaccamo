package com.revature.daos;

import com.revature.models.User;

import java.util.List;

public interface UserDAO {
    public List<User> findAll();

    public User findUser(String username);

    public boolean addUser(User user);

    public User loginUser(String username, String password);
}
