package com.revature.daos;

import com.revature.models.User;
import com.revature.services.AddressService;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private AddressService addressService = new AddressService();

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findUser(String username) {
        return null;
    }

    @Override
    public boolean addUser(User user) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "INSERT INTO users (username, full_name, address_id, phone_number, access_level, user_pass) VALUES (?,?,?,?,1,?);";
            int count = 0;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(++count, user.getUsername());
            statement.setString(++count, user.getFullName());
            statement.setInt(++count, user.getAddressID());
            statement.setString(++count, user.getPhoneNumber());
            statement.setString(++count, user.getPassword());
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
