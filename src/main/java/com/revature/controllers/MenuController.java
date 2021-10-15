package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.UserService;

import java.util.Scanner;

public class MenuController {

    private static final Scanner scan = new Scanner(System.in);
    private static final UserService userService = new UserService();
    private static final UserController userController = new UserController();
    private static final LoginController loginController = new LoginController();
    private static final AccountController accountController = new AccountController();
    public static User login = new User();

    public void menuAccess() {
        while (login.getAccessLevel() != -1) {
            switch (login.getAccessLevel()) {
                case 1:
                    userMenu();
                    break;
                case 2:
                    employeeMenu();
                    break;
                case 3:
                    adminMenu();
                    break;
                default:
                    welcomeMenu();
                    break;
            }
        }
    }

    public void welcomeMenu() {
        String choice = "";
        boolean loggedIn = false;
        while (!choice.equals("0")) {
            switch (choice) {
                case "1":
                    login = loginController.loginUser();
                    if (login == null) {
                        choice = "";
                    } else {
                        loggedIn = true;
                        choice = "0";
                    }
                    break;
                case "2":
                    userController.addUser();
                    choice = "";
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
        if (!loggedIn) {
            login.setAccessLevel(-1);
        }
    }

    public void userMenu() {
        String choice = "";
        while (!choice.equals("0")) {
            switch (choice) {
                case "1":
                    accountController.getAccounts(login.getUsername(), login);
                    choice = "";
                    break;
                case "2":
                    accountController.addAccount(login.getUsername());
                    choice = "";
                    break;
                case "9":
                    userController.displayInfo(login);
                    System.out.println("---");
                default:
                    System.out.println("1) View your accounts \n"
                            + "2) Apply for a new account \n"
                            + "9) Your info \n"
                            + "0) Logout");
                    choice = scan.nextLine();
                    break;
            }
        }
        login = new User();
    }

    public void employeeMenu() {
        String choice = "";
        while (!choice.equals("0")) {
            String username;
            switch (choice) {
                case "1":
                    System.out.println("Enter your client's username:");
                    username = scan.nextLine();
                    accountController.getAccounts(username, login);
                    choice = "";
                    break;
                case "2":
                    System.out.println("Enter your client's username:");
                    username = scan.nextLine();
                    userController.displayInfo(userService.findByUsername(username));
                    System.out.println("---");
                    choice = "";
                    break;
                case "9":
                    userController.displayInfo(login);
                    System.out.println("---");
                default:
                    System.out.println("1) View client accounts \n"
                            + "2) View client info \n"
                            + "9) Your info \n"
                            + "0) Logout");
                    choice = scan.nextLine();
                    break;
            }
        }
        login = new User();
    }

    public void adminMenu() {
        String choice = "";
        while (!choice.equals("0")) {
            String username;
            switch (choice) {
                case "1":
                    System.out.println("Enter your client's username:");
                    username = scan.nextLine();
                    accountController.getAccounts(username, login);
                    choice = "";
                    break;
                case "2":
                    System.out.println("Enter your client's username:");
                    username = scan.nextLine();
                    userController.displayInfo(userService.findByUsername(username));
                    System.out.println("---");
                    choice = "";
                    break;
                case "3":
                    accountController.getAllAccounts(login.getAccessLevel());
                    choice = "";
                    break;
                case "9":
                    userController.displayInfo(login);
                    System.out.println("---");
                default:
                    System.out.println("1) View client accounts \n"
                            + "2) View client info \n"
                            + "3) View all accounts \n"
                            + "9) Your info \n"
                            + "0) Logout");
                    choice = scan.nextLine();
                    break;
            }
        }
        login = new User();
    }
}
