package com.revature.daos;

import com.revature.models.Account;
import com.revature.models.Address;
import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {
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
}
