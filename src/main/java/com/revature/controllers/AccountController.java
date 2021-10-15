package com.revature.controllers;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.services.AccountService;
import com.revature.services.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountController {

    UserService userService = new UserService();
    AccountService accountService = new AccountService();
    Scanner scan = new Scanner(System.in);

    public void getAccounts(String username, User login) {
        User user = userService.findByUsername(username);
        int accessLevel = login.getAccessLevel();
        if (user.getUsername().equals(login.getUsername()) || accessLevel == 2 || accessLevel == 3) {
            List<Account> list = accountService.findByUser(user);
            if (list.size() == 0) {
                System.out.println("No accounts found for this user.");
            } else {
                System.out.println("Accounts for " + user.getUsername() + ":");
                List<Integer> accountsList = new ArrayList<>();
                for (Account a : list) {
                    boolean approved = a.isApproval();
                    accountsList.add(a.getAccountID());
                    if (approved) {
                        System.out.println(a.getAccountID() + ") $" + a.getBalance() + " (" + a.getAccountType() + ")");
                    } else {
                        System.out.println(a.getAccountID() + ") Pending Approval (" + a.getAccountType() + ")");
                    }
                }
                System.out.println("Enter account number for options, or 0 to go back.");
                String choice = scan.nextLine();
                while (!choice.equals("0")) {
                    if (accountsList.contains(Integer.parseInt(choice))) {
                        Account accountChoice = accountService.findByID(Integer.parseInt(choice));
                        if (accountChoice.isApproval()) {
                            accountOptions(Integer.parseInt(choice), accountsList);
                            choice = "0";
                        } else if (accessLevel > 1 && !accountChoice.isApproval()) {
                            System.out.println("Approve account? Y/N");
                            switch (scan.nextLine().toLowerCase()) {
                                case "y":
                                    accountService.approveAccount(accountChoice);
                                    System.out.println("Account approved!");
                                    choice = "0";
                                    break;
                                case "n":
                                    accountService.denyAccount(accountChoice);
                                    System.out.println("Approval denied.");
                                    choice = "0";
                                    break;
                                default:
                                    System.out.println("Didn't catch that.");
                                    break;
                            }
                        } else {
                            System.out.println("That account is still pending. \n"
                                    + "Enter account number for options, or 0 to go back.");
                            choice = scan.nextLine();
                        }
                    } else {
                        System.out.println("Try again. \n"
                                + "Enter account number for options, or 0 to go back.");
                        choice = scan.nextLine();
                    }
                }
            }
        } else {
            System.out.println("Access denied.");
        }
    }

    public void accountOptions(int id, List<Integer> accountsList) {
        Account account = accountService.findByID(id);
        String choice = "";
        while (!choice.equals("0")) {
            switch (choice) {
                case "1":
                    System.out.println("Withdrawal amount:");
                    accountService.withdraw(id, Double.parseDouble(scan.nextLine()));
                    System.out.println("Withdraw successful!");
                    choice = "";
                    break;
                case "2":
                    System.out.println("Deposit amount:");
                    accountService.deposit(id, Double.parseDouble(scan.nextLine()));
                    System.out.println("Deposit successful!");
                    choice = "";
                    break;
                case "3":
                    List<Integer> approvedAccounts = new ArrayList<>();
                    for (int i : accountsList) {
                        if (accountService.findByID(i).isApproval()) {
                            approvedAccounts.add(i);
                        }
                    }
                    if (approvedAccounts.size() != 1) {
                        System.out.println("Enter target account number from the following:");
                        for (int id2 : approvedAccounts) {
                            if (id2 != id) {
                                Account account2 = accountService.findByID(id2);
                                System.out.println(account2.getAccountID() + ") $" + account2.getBalance() + " (" + account2.getAccountType() + ")");
                            }
                        }
                        String choice2 = scan.nextLine();
                        while (!choice2.equals("0")) {
                            if (approvedAccounts.contains(Integer.parseInt(choice2))) {
                                System.out.println("Transfer amount:");
                                String transfer = scan.nextLine();
                                accountService.withdraw(id, Double.parseDouble(transfer));
                                accountService.deposit(Integer.parseInt(choice2), Double.parseDouble(transfer));
                                System.out.println("Transfer successful!");
                                choice2 = "0";
                            } else {
                                System.out.println("That account is not available or does not exist.");
                                System.out.println("Enter target account number from the following:");
                                choice2 = scan.nextLine();
                            }
                        }
                    } else {
                        System.out.println("No other accounts to transfer to.");
                    }
                    choice = "";
                    break;
                default:
                    System.out.println(account.getAccountID() + ") $" + account.getBalance() + " (" + account.getAccountType() + ")");
                    System.out.println("What would you like to do? \n"
                            + "1) Withdraw \n"
                            + "2) Deposit \n"
                            + "3) Transfer to another account \n"
                            + "0) Cancel");
                    choice = scan.nextLine();
            }
        }
    }

    public void addAccount(String username) {
        System.out.println("What kind of account would you like to open? \n"
                + "1) Checking \n"
                + "2) Savings \n"
                + "0) Cancel");
        String choice = scan.nextLine();
        Account account = new Account();
        account.setUserID(username);
        while (!choice.equals("0")) {
            switch (choice) {
                case "1":
                    account.setAccountType("checking");
                    choice = "0";
                    break;
                case "2":
                    account.setAccountType("savings");
                    choice = "0";
                    break;
                default:
                    System.out.println("Choose an available option:");
                    System.out.println("What kind of account would you like to open? \n"
                            + "1) Checking \n"
                            + "2) Savings \n"
                            + "0) Cancel");
                    choice = scan.nextLine();
                    break;
            }
        }
        if (accountService.addAccount(account)) {
            System.out.println("Applied for a new " + account.getAccountType() + " account.");
        }
    }
}
