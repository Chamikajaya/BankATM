package com.oop.learn;

import java.util.ArrayList;

public class User {
    private String name;
    private String  id;
    private String nationality;
    private String occupation;
    private String address;
    private int age;
    private boolean gender; // true = Male, False = Female
    private String currency;  // To get to know the currency which the user uses


    private ArrayList<Account> accounts;  // We will store all accounts of this specific user in this array list


    public User(String name, String nationality, String occupation, String address, int age, boolean gender, String currency, Bank bank) {
        this.name = name;
        this.nationality  = nationality;
        this.occupation = occupation;
        this.address = address;
        this.age = age;
        this.gender = gender;
        this.currency = currency;
        // get user's id  -> Using our Bank class method
        this.id = bank.getNewUserId();
        // Create an empty list of accounts for this specific user
        this.accounts = new ArrayList<>();

    }


    // Method to add an account to Accounts arraylist
    public void addAccount(Account account, String currency) {
        if (account.getCurrenyUsed().equals(currency)) {
            this.accounts.add(account);
        }
        else {
            System.out.println("Sorry! All of your accounts must use same currency. :(");
        }
    }

    // Getter to return user's Id
    public String getId(){
        return this.id;
    }

    public ArrayList<Account> getAccounts(){
        return this.accounts;
    }


}
