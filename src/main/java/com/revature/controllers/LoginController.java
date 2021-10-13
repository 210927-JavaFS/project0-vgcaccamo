package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.UserService;

import java.util.Scanner;

public class LoginController {

    Scanner scan = new Scanner(System.in);
    UserService userService = new UserService();

    public User loginUser() {
        System.out.println("Username:");
        String username = scan.nextLine();
        System.out.println("Password:");
        String password = scan.nextLine();
        User user = userService.loginUser(username, password);
        if (user != null) {
            System.out.println("Logged in!");
            System.out.println("Welcome " + user.getUsername());
        } else {
            System.out.println("Login failed.");
        }
        return user;
    }
}
