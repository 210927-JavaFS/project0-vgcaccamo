package com.revature.controllers;

import com.revature.models.Login;

import java.util.Scanner;

public class MenuController {

    private static Scanner scan = new Scanner(System.in);
    private static UserController userController = new UserController();
    private static LoginController loginController = new LoginController();
    private static AccountController accountController = new AccountController();
    public static Login login = new Login();

    public void menuAccess() {
        while (login.getAccessLevel() != -1) {
            while (login.getAccessLevel() == 0) {
                welcomeMenu();
            }
            while (login.getAccessLevel() == 1) {
                userMenu();
            }
        }
    }

    public void welcomeMenu() {
        String choice = new String();
        boolean loggedIn = false;
        while (!choice.equals("0")) {
            switch (choice) {
                case "1":
                    login = loginController.loginUser();
                    if (login == null) {
                        choice = "-1";
                    } else {
                        loggedIn = true;
                        choice = "0";
                    }
                    break;
                case "2":
                    userController.addUser();
                    choice = "-1";
                    break;
                default:
                    System.out.println("Welcome to Based American National Bank.");
                    System.out.println("1) Login \n"
                            + "2) Register \n"
                            + "0) Exit");
                    choice = scan.nextLine();
                    break;
            }
        }
        if (loggedIn == false) {
            login.setAccessLevel(-1);
        }
    }

    public void userMenu() {
        String choice = new String();
        while (!choice.equals("0")) {
            switch (choice) {
                case "1":
                    accountController.getAccounts(login.getUsername());
                    choice = "-1";
                    break;
                case "2":
                    break;
                case "9":
                    break;
                default:
                    System.out.println("Welcome " + login.getUsername());
                    System.out.println("1) View your accounts \n"
                            + "2) Apply for a new account \n"
                            + "9) Your info \n"
                            + "0) Logout");
                    choice = scan.nextLine();
                    break;
            }
        }
        login.setUsername(null);
        login.setAccessLevel(0);
    }
}
