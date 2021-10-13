package com.revature.models;

import java.util.Objects;

public class User {

    private String username;
    private String fullName;
    private int addressID;
    private String phoneNumber;
    private int accessLevel;
    private String password;

    public User(String username, String fullName, int addressID, String phoneNumber, int accessLevel, String password) {
        this.username = username;
        this.fullName = fullName;
        this.addressID = addressID;
        this.phoneNumber = phoneNumber;
        this.accessLevel = accessLevel;
        this.password = password;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return addressID == user.addressID && accessLevel == user.accessLevel && Objects.equals(username, user.username) && Objects.equals(fullName, user.fullName) && Objects.equals(phoneNumber, user.phoneNumber) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, fullName, addressID, phoneNumber, accessLevel, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", addressID=" + addressID +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", accessLevel=" + accessLevel +
                ", password='" + password + '\'' +
                '}';
    }
}
