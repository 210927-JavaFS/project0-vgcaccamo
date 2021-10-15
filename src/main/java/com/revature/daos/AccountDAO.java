package com.revature.daos;

import com.revature.models.Account;
import com.revature.models.User;

import java.util.List;

public interface AccountDAO {
    Account findByID(int id);

    List<Account> findByUser(User user);

    boolean addAccount(Account account);

    Double withdraw(int id, double amount);

    Double deposit(int id, double amount);

    boolean approveAccount(Account account);

    boolean deleteAccount(Account account);
}
