package com.revature.models;

import java.util.Objects;

public class Login {

    private String username;
    private int accessLevel;

    public Login(String username, int accessLevel) {
        this.username = username;
        this.accessLevel = accessLevel;
    }

    public Login() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Login login = (Login) o;
        return accessLevel == login.accessLevel && Objects.equals(username, login.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, accessLevel);
    }

    @Override
    public String toString() {
        return "Login{" +
                "username='" + username + '\'' +
                ", accessLevel=" + accessLevel +
                '}';
    }
}
