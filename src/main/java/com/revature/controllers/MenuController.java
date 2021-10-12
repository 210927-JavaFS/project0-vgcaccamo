package com.revature.controllers;

import java.util.Scanner;

public class MenuController {

    private static Scanner scan = new Scanner(System.in);
    private static AddressController addressController = new AddressController();

    public void welcomeMenu() {
        System.out.println("Welcome to Based American National Bank. Choose an option!");
        System.out.println("1) Add an address \n"
                + "0) Exit");
        String choice = scan.nextLine();

        while (!choice.equals("0")) {
            switch (choice) {
                case "1":
                    addressController.addAddress();
                    System.out.println("1) Add an address \n"
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
