package com.bank;

public class User {
    private int id;
    private String password;
    private double balance;
    private int mobileNum;

    User(int id, String password){
        this.id = id;
        this.password = password;
        balance = 500;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(int mobileNum) {
        this.mobileNum = mobileNum;
    }

    public boolean verifyPassword(String password){
        return this.password.equals(password);
    }
}
