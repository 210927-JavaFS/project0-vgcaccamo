package com.revature.daos;

import com.revature.models.Address;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressDAOImpl implements AddressDAO {
    @Override
    public List<Address> findAll() {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM addresses;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            List<Address> list = new ArrayList<>();

            while (result.next()) {
                Address address = new Address();
                address.setStreet(result.getString("address_street"));
                address.setCity(result.getString("address_city"));
                address.setState(result.getString("address_state"));
                address.setZip(result.getString("address_zip"));
                list.add(address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Address findAddress(int id) {
        return null;
    }

    @Override
    public boolean addAddress(Address address) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "INSERT INTO addresses (address_street, address_city, address_state, address_zip) " + "VALUES (?,?,?,?);";
            int count = 0;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(++count, address.getStreet());
            statement.setString(++count, address.getCity());
            statement.setString(++count, address.getState());
            statement.setString(++count, address.getZip());
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateAddress(Address address) {
        return false;
    }
}
