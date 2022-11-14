package com.atm3;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        List<user> userListInMain = new LinkedList<>();

        userListInMain.add(new user("vijay", 1234, 5000));
        userListInMain.add(new user("ajay", 5675, 6000));
        userListInMain.add(new user("siddartha", 4567, 7000));

        char LoopCheck = 'y';
        while (LoopCheck == 'y') {
            System.out.println("""
                    welcome :
                    1--> To create your account
                    2--> to LogIn
                    """);
            int switchOption = scanner.nextInt();
            scanner.nextLine();
            switch (switchOption) {
                case 1 -> {
                    System.out.println("enter your name");
                    String newUserName = scanner.nextLine();
                    System.out.println("set your password");
                    int newPass = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("enter initial deposit ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    accountCreation accountCreation = new accountCreation(userListInMain);
                    accountCreation.create(new user(newUserName, newPass, amount));
                }
                case 2 -> {
                    System.out.println("enter your name");
                    String Name = scanner.nextLine();
                    System.out.println("enter your password");
                    int Pass = scanner.nextInt();
                    scanner.nextLine();
                    logInDetails logInDetails = new logInDetails(Name, Pass);
                    boolean isLogIn = false;
                    for (user u : userListInMain) {
                        if (u.getUserName().equals(logInDetails.getUserName()) && u.getPassword() == logInDetails.getPassword()) {
                            System.out.println("Logged In");
                            isLogIn = true;
                            break;
                        }
                    }
                    if (!isLogIn) {
                        System.out.println("please recheck your details ");
                    }
                    if (isLogIn) {
                        char innerLoop = 'y';
                        while (innerLoop == 'y') {
                        System.out.println("enter \n1-->deposit Amount\n 2-->withDraw Amount\n 3-->check your balance\n 4-->Your Transactions");
                        int check = scanner.nextInt();
                        scanner.nextLine();
                            switch (check) {
                                case 1:
                                    System.out.println("enter amount you want to deposit");
                                    double LogInAmount = scanner.nextDouble();
                                    scanner.nextLine();
                                    for (user u : userListInMain) {
                                        if (u.getUserName().equals(logInDetails.getUserName()) && u.getPassword() == logInDetails.getPassword()) {
                                            u.addTransactions(LogInAmount);
                                            u.amount += LogInAmount;
                                            System.out.println("amount successfully deposited in your account");
                                            break;
                                        }
                                    }
                                    break;
                                case 2:
                                    System.out.println("Amount to withDraw");
                                    double LogInWithDraw = scanner.nextDouble();
                                    scanner.nextLine();
                                    for (user u : userListInMain) {
                                        if (u.getUserName().equals(logInDetails.getUserName()) && u.getPassword() == logInDetails.getPassword()) {
                                            u.addTransactions(-1 * LogInWithDraw);
                                            u.amount -= LogInWithDraw;
                                            System.out.println("successfully amount is withDrawn");
                                            break;
                                        }
                                    }
                                    break;
                                case 3:
                                    for (user u : userListInMain) {
                                        if (u.getUserName().equals(logInDetails.getUserName()) && u.getPassword() == logInDetails.getPassword()) {
                                            System.out.println("balance in your account is " + u.getAmount());
                                            break;
                                        }
                                    }
                                    break;
                                case 4:
                                    for (user u : userListInMain) {
                                        if (u.getUserName().equals(logInDetails.getUserName()) && u.getPassword() == logInDetails.getPassword()) {
                                            System.out.println(u.getTransactions());
                                            break;
                                        }
                                    }
                                    break;
                            }
                            System.out.println("Again if we you want to re-use options please enter y or n");
                            innerLoop = scanner.next().charAt(0);
                        }

                    }
                }
            }
            System.out.println("enter yes for log In/creation of account or enter no");
             LoopCheck=scanner.next().charAt(0);
        }
    }
    }
