package com.bank;

import java.util.Scanner;

public class BankOperator {
    public static void main(String[] args) {
        /*login --> user,password
        create account ->>user id,password,amount
        send money from 1 account to another ->user id ,password,amount,destination account number
        add balance -> user,password,amount
        check balance -> user,password
        withdraw money ->user,password,amount
        delete account -> user,password
        */
        Bank BOBbank = new Bank();
        System.out.println("Welcome to BOBbank!");
        int option;
        do {
            System.out.println("\n"+"Choose the option");
            System.out.println("1. Create account");
            System.out.println("2. Transfer money to other account");
            System.out.println("3. Add money");
            System.out.println("4. Check balance");
            System.out.println("5. Withdraw money");
            System.out.println("6. delete account");
            System.out.println("8. Exit");

            Scanner sc = new Scanner(System.in);
            option = sc.nextInt();

            int id;
            String password;
            double amount;
            int destId;

            switch (option) {
                case 1:
                    System.out.println("Enter user id number");
                    id = sc.nextInt();
                    System.out.println("Enter password");
                    password = sc.next();

                    BOBbank.addUser(id, password);
                    break;

                case 2:
                    System.out.println("Enter user id number");
                    id = sc.nextInt();
                    System.out.println("Enter password");
                    password = sc.next();
                    System.out.println("Enter the amount");
                    amount = sc.nextInt();
                    System.out.println("Enter destination user id");
                    destId = sc.nextInt();

                    BOBbank.transferMoney(id,password,amount,destId);
                    break;

                case 3:
                    System.out.println("Enter user id number");
                    id = sc.nextInt();
                    System.out.println("Enter password");
                    password = sc.next();
                    System.out.println("Enter the amount");
                    amount = sc.nextInt();

                    BOBbank.addMoney(id, password, amount);
                    break;

                case 4:
                    System.out.println("Enter user id number");
                    id = sc.nextInt();
                    System.out.println("Enter password");
                    password = sc.next();

                    BOBbank.checkBalance(id, password);
                    break;

                case 5:
                    System.out.println("Enter user id number");
                    id = sc.nextInt();
                    System.out.println("Enter password");
                    password = sc.next();
                    System.out.println("Enter the amount");
                    amount = sc.nextInt();

                    BOBbank.withdrawMoney(id, password, amount);
                    break;

                case 6:
                    System.out.println("Enter user id number");
                    id = sc.nextInt();
                    System.out.println("Enter password");
                    password = sc.next();

                    BOBbank.deleteAccount(id, password);

                    break;

                case 8:
                    System.out.println("Exiting...");
                    break;

                default:
                    break;
            }
        }while (option != 8);
    }
}