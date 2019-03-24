package com.vibs.mvvm_demo.model;

public class User {

    private String userName;
    private String password;
    public String userNameHint;
    public String passwordHint;

    public User(String userNameHint, String passwordHint) {
        this.userNameHint = userNameHint;
        this.passwordHint = passwordHint;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserNameHint() {
        return userNameHint;
    }

    public void setUserNameHint(String userNameHint) {
        this.userNameHint = userNameHint;
    }

    public String getPasswordHint() {
        return passwordHint;
    }

    public void setPasswordHint(String passwordHint) {
        this.passwordHint = passwordHint;
    }
}
