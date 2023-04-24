package com.oop.learn;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Bank implements iTransaction{
    private String name;
    private ArrayList<User> customers;
    private ArrayList<Account> allAccounts;

    public Bank(String name){    // Constructor
        this.name = name;
        this.customers = new ArrayList<>();
        this.allAccounts = new ArrayList<>();
    }

    // Method for giving loans
    public boolean giveLoans(double amount, double rate, String paymentMethod, int duration, String givenId){
        for (var account : allAccounts){
            if (account.getId().equals(givenId)){
                return true;  // Since this user has an account in our bank, I approve his loan
            }
        }
        return false;
    }


    public String getNewUserId() {  // To generate an id for the user in random manner
        int idLength = 5;
        Random random = new Random();
        String id = "";
        boolean isUnique = false;
        while (!isUnique){
            for (int i = 0; i < idLength; i++){
                int x =  random.nextInt(10);
                id += Integer.toString(x);
            }
            for (var customer : customers){
                if (customer.getId().equals(id)){
                    isUnique = true;
                    break;
                }
            }
        }
        return id;
}


    public String generatePin() {  // To generate a pin  for the user in random manner
        int pinLength = 4;
        Random random = new Random();
        String id = "";
        boolean isUnique = false;
        while (!isUnique){
            for (int i = 0; i < pinLength; i++){
                int x =  random.nextInt(10);
                id += Integer.toString(x);
            }
            for (var customer : customers){
                if (customer.getId().equals(id)){
                    isUnique = true;
                    break;
                }
            }
        }
        return id;
    }

    public String getAccId() {   // I use this to randomly generate a userId when creating a new user
        int idLength = 5;
        Random random = new Random();
        String id = "";
        boolean isUnique = false;
        while (!isUnique){
            for (int i = 0; i < idLength; i++){
                int x =  random.nextInt(10);
                id += Integer.toString(x);
            }
            for (var account : allAccounts){
                if (account.getId().equals(id)){
                    isUnique = true;
                    break;
                }
            }
        }
        return id;
    }
    // Method to add an account to allAccounts arraylist
    public void addAccount(Account account) {
        this.allAccounts.add(account);
    }

    // Create a user and add that user to customers list
    public User createUser(String name,  String nationality, String occupation, String address, int age, boolean gender, String currency,Bank bank, String branch, double rate)  {
        User bankUser = new User(name, nationality, occupation, address, age, gender, currency, this);
        //add the newly created user into customers list
        this.customers.add(bankUser);

        // When a new user is created with that we will create a savings account as well
        Savings acc = new Savings(bankUser, currency, generatePin(),branch, rate, this );

        // Now we need to add this savings account into allAccounts list    -> To do this we will call addAccount method we created
        this.addAccount(acc);
        return bankUser;

 }
        public Account checker(String enteredId){
            ArrayList<Account> x = new ArrayList<>();
            for (var customer :customers){
                if (enteredId.equals(customer.getId())){
                    x = customer.getAccounts();  // All accounts of the user will be shown
                    System.out.println(x);
                }
            }
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter yor pin number: ");
            String enteredPin = input.nextLine();
            for (var acc : x){
                if (acc.getPin().equals(enteredPin)){
                    return acc;
                }
            }
            return null;

        }

    public void viewBalane(Account account){  // To view the balance of our account
        System.out.println("Your net balance is " + account.getBalance() + account.getCurrenyUsed());
    }

    public void deposit(Account account, double depoMoney){  // To deposit money
        double new_balance = account.balance + depoMoney;
        account.setBalance(new_balance);
    }
    // to withdraw
    public void withdraw(Account account, double takenMoney){
        if (account.balance < takenMoney){
            System.out.println("Your withdrawal could not be done due to insufficient funds. ");
            viewBalane(account);
        }
        else {
            System.out.println("Money withdrawal successfully done. :)");
            double new_balance = account.balance - takenMoney;
            account.setBalance(new_balance);
            viewBalane(account);
        }
    }





}
