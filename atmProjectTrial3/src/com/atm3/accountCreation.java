package com.atm3;


import java.util.List;

public class accountCreation {
   List<user> userList;

    public accountCreation(List<user> userList) {
        this.userList = userList;
    }
    public void create(user userDetails){
        boolean isThere=false;
        for (user u:userList){
            if(u.getUserName().equals(userDetails.getUserName())&&u.getPassword()==userDetails.getPassword()){
                System.out.println("account already exists");
                isThere=true;
                break;
            }
        }if(!isThere){
            System.out.println("account is successfully created ");
            userList.add(userDetails);
        }



    }

}
