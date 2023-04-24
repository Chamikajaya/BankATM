package com.oop.learn;

public class Savings extends Account {
    private String accType;
    private double interestRate;
    public Savings(User owner, String currencyUsed, String pin, String branch,  double interestRate,Bank bank) {
        super(owner, currencyUsed, pin,branch, bank);
        this.accType = "Savings";
        this.interestRate = interestRate;
    }



    // Since bank pays interest for savings accounts
    public double payInterest(Account account){
        double addedValue = account.balance * ( (interestRate) / 100 );
        account.balance += account.balance + addedValue; // Returns the total balance after paying the interest
        return account.balance;
    }
}
