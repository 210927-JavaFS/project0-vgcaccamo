package com.revature.daos;

import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public List<User> findAll() {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM users;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            List<User> List = new ArrayList<>();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User findUser(String username) {
        return null;
    }
}
