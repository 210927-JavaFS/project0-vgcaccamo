package com.revature.controllers;

import java.util.Scanner;

public class MenuController {

    private static Scanner scan = new Scanner(System.in);
    private static UserController userController = new UserController();

    public void welcomeMenu() {
        System.out.println("Welcome to Based American National Bank.");
        System.out.println("1) Login \n"
                + "2) Register \n"
                + "0) Exit");
        String choice = scan.nextLine();

        while (!choice.equals("0")) {
            switch (choice) {
                case "1":
                    System.out.println("This ain't workin' yet.");
                    System.out.println("1) Login \n"
                            + "2) Register \n"
                            + "0) Exit");
                    choice = scan.nextLine();
                    break;
                case "2":
                    userController.addUser();
                    System.out.println("1) Login \n"
                            + "2) Register \n"
                            + "0) Exit");
                    choice = scan.nextLine();
                    break;
                default:
                    System.out.println("Type 0 to exit.");
                    break;
            }
        }
    }
}
