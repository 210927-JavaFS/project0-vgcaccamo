package com.revature.daos;

import com.revature.models.Account;
import com.revature.models.User;

import java.util.List;

public interface AccountDAO {
    public Account findByID(int id);

    public List<Account> findByUser(User user);

    public boolean addAccount(Account account);

    public boolean withdraw(int id, double amount);

    public boolean deposit(int id, double amount);
}
