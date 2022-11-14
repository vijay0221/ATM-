package com.atm3;

public class logInDetails {
    private String userName;
    private int password;

    public logInDetails(String userName,int password) {
        this.userName = userName;
        this.password=password;
    }

    public String getUserName() {
        return userName;
    }


    public int getPassword() {
        return password;
    }
}

