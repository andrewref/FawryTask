package com.fawry.service;

public class Customer {
    private String name;
    private double balance;

    public Customer(String name,double balance) {
        this.name =name;
        this.balance =balance;
    }
    public String getName() {
        return name;
    }
    public double getBalance() {
        return balance;
    }
    public void pay(double amount) {
        if (amount <= balance) {
            balance -= amount;
        }
    }
}
