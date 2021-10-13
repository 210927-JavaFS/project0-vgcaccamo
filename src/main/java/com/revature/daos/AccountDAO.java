package com.revature.daos;

import com.revature.models.Account;
import com.revature.models.User;

import java.util.List;

public interface AccountDAO {
    public List<Account> findByUser(User user);
}
