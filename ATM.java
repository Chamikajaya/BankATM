package com.oop.learn;

import java.util.Scanner;

public class ATM {
    public static void main(String[] args)  {
        Scanner input = new Scanner(System.in);
        Bank bank = new Bank("ABC");
        User u1 = bank.createUser("Chamika","Sri Lanka", "Student", "Kalutara", 21, true, "rupees", bank, "Colombo Main", 0.05);
        System.out.println("Hello, welcome to ABC ATM :)");
        System.out.println("Please enter your account id : ");
        String userId = input.nextLine();
        Account y = bank.checker(userId);
        System.out.println("Please enter your option (1/ 2/ 3 ior 4): ");
        System.out.println("1. View Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Exit");
        int userOption = input.nextInt();
        switch (userOption){
            case 1 -> bank.viewBalane(y);
            case 2 -> bank.withdraw(y, 2000);
            case 3 -> bank.deposit(y, 10000);
            case 4-> System.exit(0);
            default -> System.out.println("Please add 1, 2, 3, or 4 only.");
        }





















    }































}
