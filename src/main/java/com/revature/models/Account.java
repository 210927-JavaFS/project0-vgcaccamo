package com.revature.models;

import java.util.Objects;

public class Account {

    private int accountID;
    private String userID;
    private String accountType;
    private double balance;
    private boolean approval;

    public Account(String userID, String accountType, double balance, boolean approval) {
        this.userID = userID;
        this.accountType = accountType;
        this.balance = balance;
        this.approval = approval;
    }

    public Account() {
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isApproval() {
        return approval;
    }

    public void setApproval(boolean approval) {
        this.approval = approval;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountID == account.accountID && Double.compare(account.balance, balance) == 0 && approval == account.approval && Objects.equals(userID, account.userID) && Objects.equals(accountType, account.accountType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountID, userID, accountType, balance, approval);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountID=" + accountID +
                ", userID='" + userID + '\'' +
                ", accountType='" + accountType + '\'' +
                ", balance=" + balance +
                ", approval=" + approval +
                '}';
    }
}
