package com.revature.daos;

import com.revature.models.Address;
import com.revature.models.Login;
import com.revature.models.User;
import com.revature.services.AddressService;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM users WHERE username = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                User user = new User();
                user.setUsername(username);
                user.setFullName(result.getString("full_name"));
                user.setAddressID(result.getInt("address_id"));
                user.setPhoneNumber(result.getString("phone_number"));
                user.setAccessLevel(result.getInt("access_level"));
                user.setPassword(result.getString("user_pass"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    @Override
    public Login loginUser(String username, String password) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT access_level FROM users WHERE username = ? AND user_pass = ?;";
            int count = 0;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(++count, username);
            statement.setString(++count, password);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                Login login = new Login();
                login.setUsername(username);
                login.setAccessLevel(result.getInt("access_level"));
                return login;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
