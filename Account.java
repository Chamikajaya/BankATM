package com.oop.learn;

import java.util.ArrayList;

public class Account {
    private String accId;
    private User owner;  // Account Holder
    private String currenyUsed;
    private String branch;
    private String pin;
    protected  double balance;

    public Account( User owner, String currencyUsed, String pin, String branch,  Bank bank){
        // Set the account type and the owner
        this.owner = owner;  // We will use userid for this
        this.currenyUsed = currencyUsed;
        this.accId = bank.getAccId();
        //When we create a new account, call this to generate a pin for the account
        bank.generatePin();
        // Add this account to all accounts list
        bank.addAccount(this);

    }

    // Getter to return account Id
    public String getId() {
        return this.accId;
    }

    public String getPin() {
        return pin;
    }

    public String getCurrenyUsed() {
        return currenyUsed;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
