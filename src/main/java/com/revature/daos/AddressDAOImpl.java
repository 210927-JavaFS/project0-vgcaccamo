package com.revature.daos;

import com.revature.models.Address;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressDAOImpl implements AddressDAO {
    @Override
    public Address findByAddress(Address address) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT address_id FROM addresses WHERE address_street = ? AND address_city = ? AND address_state = ? AND address_zip = ?;";
            int count = 0;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(++count, address.getStreet());
            statement.setString(++count, address.getCity());
            statement.setString(++count, address.getState());
            statement.setString(++count, address.getZip());
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                Address newAddress = new Address();
                newAddress.setId(result.getInt("address_id"));
                newAddress.setStreet(address.getStreet());
                newAddress.setCity(address.getCity());
                newAddress.setState(address.getState());
                newAddress.setZip(address.getZip());
                return newAddress;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Address findById(int id) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM addresses WHERE address_id = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                Address address = new Address();
                address.setId(result.getInt("address_id"));
                address.setStreet(result.getString("address_street"));
                address.setCity(result.getString("address_city"));
                address.setState(result.getString("address_state"));
                address.setZip(result.getString("address_zip"));
                return address;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
}
