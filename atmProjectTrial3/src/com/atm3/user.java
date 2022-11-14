package com.atm3;
import java.util.LinkedList;
import java.util.List;

public class user {
    private  String userName;
    private  int password;
    protected double amount;
    List<Double> transactions;

    public user(String userName, int password,double amount) {
        this.userName = userName;
        this.password = password;
        this.amount = amount;
        this.transactions = new LinkedList<>();
    }

    public String getUserName() {
        return userName;
    }

    public int getPassword() {
        return password;
    }

    public double getAmount() {
        return amount;
    }
    public void addTransactions(double amount){
        this.transactions.add(amount);
    }

    public List<Double> getTransactions() {
        return transactions;
    }
}
