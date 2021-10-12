package com.revature.controllers;

import com.revature.models.Address;
import com.revature.services.AddressService;

import java.util.Scanner;

public class AddressController {

    private AddressService addressService = new AddressService();
    private Scanner scan = new Scanner(System.in);

    public void addAddress() {
        System.out.println("Welcome to the address wizard. What is your street address (number + street name)?");
        String street = scan.nextLine();
        System.out.println("What city is this address located in?");
        String city = scan.nextLine();
        System.out.println("What is the state's 2-letter postal code?");
        String state = scan.nextLine();
        System.out.println("What is the address's zip code?");
        String zip = scan.nextLine();

        Address address = new Address(street, city, state, zip);

        if (addressService.newAddress(address)) {
            System.out.println("Address successfully added!");
        } else {
            System.out.println("Something went wrong. Try again later.");
        }
    }
}
