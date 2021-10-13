package com.revature.daos;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {
    @Override
    public Account findByID(int id) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM accounts where account_id = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Account account = new Account();
                account.setAccountID(result.getInt("account_id"));
                account.setUserID(result.getString("user_id"));
                account.setAccountType(result.getString("account_type"));
                account.setBalance(result.getDouble("balance"));
                account.setApproval(result.getBoolean("approval"));
                return account;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Account> findByUser(User user) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM accounts WHERE user_id = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, user.getUsername());
            ResultSet result = statement.executeQuery();
            List<Account> list = new ArrayList<>();
            while (result.next()) {
                Account account = new Account();
                account.setAccountID(result.getInt("account_id"));
                account.setUserID(result.getString("user_id"));
                account.setAccountType(result.getString("account_type"));
                account.setBalance(result.getDouble("balance"));
                account.setApproval(result.getBoolean("approval"));
                list.add(account);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addAccount(Account account) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "INSERT INTO accounts (user_id, account_type) " + "VALUES (?,?);";
            int count = 0;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(++count, account.getUserID());
            statement.setString(++count, account.getAccountType());
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean withdraw(int id, double amount) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "UPDATE accounts SET balance = (balance - ?) WHERE account_id = ?;";
            int count = 0;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setDouble(++count, amount);
            statement.setInt(++count, id);
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deposit(int id, double amount) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "UPDATE accounts SET balance = (balance + ?) WHERE account_id = ?;";
            int count = 0;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setDouble(++count, amount);
            statement.setInt(++count, id);
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
