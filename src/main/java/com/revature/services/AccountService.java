package com.revature.services;

import com.revature.daos.AccountDAO;
import com.revature.daos.AccountDAOImpl;
import com.revature.models.Account;
import com.revature.models.User;

import java.util.List;

public class AccountService {

    AccountDAO accountDAO = new AccountDAOImpl();

    public List<Account> findByUser(User user) {
        return accountDAO.findByUser(user);
    }
}
