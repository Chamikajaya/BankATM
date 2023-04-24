package com.oop.learn;

public class Current extends Account {
    private String accType;
    public Current(User owner, String currencyUsed, String pin, String branch, Bank bank) {
        super(owner, currencyUsed, pin, branch, bank);
        this.accType = "Current";
    }
}
