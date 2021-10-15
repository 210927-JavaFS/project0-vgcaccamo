package com.revature.services;

import com.revature.daos.AccountDAO;
import com.revature.daos.AccountDAOImpl;
import com.revature.models.Account;
import com.revature.models.User;

import java.util.List;

public class AccountService {

    AccountDAO accountDAO = new AccountDAOImpl();

    public Account findByID(int id) {
        return accountDAO.findByID(id);
    }

    public List<Account> findByUser(User user) {
        return accountDAO.findByUser(user);
    }

    public boolean addAccount(Account account) {
        return accountDAO.addAccount(account);
    }

    public boolean withdraw(int id, double amount) {
        return accountDAO.withdraw(id, amount);
    }

    public boolean deposit(int id, double amount) {
        return accountDAO.deposit(id, amount);
    }

    public boolean approveAccount(Account account) {
        return accountDAO.approveAccount(account);
    }

    public boolean denyAccount(Account account) {
        return accountDAO.deleteAccount(account);
    }
}
