package com.bank;

import java.util.HashMap;

public class Bank {
    private HashMap<Integer, User> Users;

    Bank(){
        Users = new HashMap<>();
    }

    public void addUser(int id, String password){
        if(Users.containsKey(id)){
            System.out.println("User already exists");
        }
        else{
            User newUser = new User(id, password);
            Users.put(id, newUser);
            System.out.println("Account successfully created!");
        }
    }

    public void transferMoney(int id, String password, double amount, int destId){
        if(!checkCredentials(id, password)) {
            System.out.println("Please enter valid user details");
        }else if(!Users.containsKey(destId)){
            System.out.println("Please enter valid destination user id");
        }else if(amount > Users.get(id).getBalance()){
            System.out.println("Amount is not available in balance. Please try again");
        }else{
            User currUser = Users.get(id); // sender and receiver names might be better
            User destUser = Users.get(destId);

            double currUserBal = currUser.getBalance() - amount;
            currUser.setBalance(currUserBal);

            double destUserBal = destUser.getBalance() + amount;
            destUser.setBalance(destUserBal);

            System.out.println("Transferred successfully!");
            System.out.println("Your new Balance is " + Users.get(id).getBalance());
        }
    }

    public void addMoney(int id, String password, double amount){
        if(!checkCredentials(id, password)) {
            System.out.println("Please enter valid details");
        }else{
            User user = Users.get(id);
            user.setBalance(user.getBalance() + amount);
            System.out.println("Transaction successful.");
            System.out.println("Your new Balance is " + Users.get(id).getBalance());
        }
    }

    public void checkBalance(int id, String password){
        if(!checkCredentials(id, password)) {
            System.out.println("Please enter valid details");
        }else{
            System.out.println("Your current balance is " + Users.get(id).getBalance());
        }
    }

    public void withdrawMoney(int id, String password, double amount){
        if(!checkCredentials(id, password)) {
            System.out.println("Please enter valid details");
        }else if(!(Users.get(id).getBalance() >= amount)) {
            System.out.println("Entered amount is not available in your account");
            System.out.println("Your current balance is "+ Users.get(id).getBalance());
        }else{
            Users.get(id).setBalance(Users.get(id).getBalance() - amount);
            System.out.println("Transaction successful!");
            System.out.println("Your current balance is " + Users.get(id).getBalance());
        }
    }

    public void deleteAccount(int id, String password){
        if(!checkCredentials(id, password)){
            System.out.println("Please enter valid details");
        }else{
            System.out.println("Your current balance is " + Users.get(id).getBalance());
            System.out.println("Please receive your money...");
            System.out.println("Thank you for choosing BOB bank");
            Users.remove(id);
            System.out.println("Your account is successfully deleted");
        }
    }

    public boolean checkCredentials(int id, String password){
        if(!Users.containsKey(id))
            return false;
        return Users.get(id).verifyPassword(password);
    }
}
