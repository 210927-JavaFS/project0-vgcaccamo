package com.revature.controllers;

import com.revature.models.Login;
import com.revature.services.UserService;

import java.util.Scanner;

public class LoginController {

    Scanner scan = new Scanner(System.in);
    UserService userService = new UserService();

    public Login loginUser() {
        System.out.println("Username:");
        String username = scan.nextLine();
        System.out.println("Password:");
        String password = scan.nextLine();
        Login login = userService.loginUser(username, password);
        if (login != null) {
            System.out.println("Logged in!");
        } else {
            System.out.println("Login failed.");
        }
        return login;
    }

    public void logoutUser() {

    }
}
