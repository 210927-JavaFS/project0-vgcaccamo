package com.revature.controllers;

import com.revature.models.Address;
import com.revature.models.User;
import com.revature.services.AddressService;
import com.revature.services.UserService;

import java.util.Scanner;

public class UserController {

    Scanner scan = new Scanner(System.in);
    UserService userService = new UserService();
    AddressService addressService = new AddressService();

    public void addUser() {
        System.out.println("Welcome to the user wizard. Enter your new username:");
        String username = scan.nextLine();
        System.out.println("Enter your new password:");
        String password = scan.nextLine();
        System.out.println("Enter your full name:");
        String fullName = scan.nextLine();
        System.out.println("Enter your 10-digit phone number");
        String phone = scan.nextLine();
        System.out.println("Enter your street address (number + street name):");
        String street = scan.nextLine();
        System.out.println("Enter your city:");
        String city = scan.nextLine();
        System.out.println("Enter your state's 2-letter postal code:");
        String state = scan.nextLine();
        System.out.println("Enter your 5-digit zip code:");
        String zip = scan.nextLine();

        Address address = new Address(street, city, state, zip);
        if (addressService.findByAddress(address) == null) {
            addressService.newAddress(address);
        }
        int addressID = addressService.findByAddress(address).getId();
        User user = new User(username, fullName, addressID, phone, 1, password);

        if (userService.newUser(user)) {
            System.out.println("User successfully added!");
        } else {
            System.out.println("Something went wrong. Try again later.");
        }
    }
}
