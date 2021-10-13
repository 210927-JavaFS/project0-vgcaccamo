package com.revature.controllers;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.services.AccountService;
import com.revature.services.UserService;

import java.util.List;

public class AccountController {

    UserService userService = new UserService();
    AccountService accountService = new AccountService();

    public void getAccounts(String username) {
        User user = userService.findByUsername(username);
        List<Account> list = accountService.findByUser(user);
        if (list.size() == 0) {
            System.out.println("No accounts found for this user.");
        }
        for (Account a : list) {
            System.out.println(a);
        }
    }
}
