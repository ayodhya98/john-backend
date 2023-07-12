package com.example.ABCBank.bankingobjects;

public class Ammount {
    double amount;

    public Ammount(double amount) {
        this.amount = amount;
    }

    public Ammount() {
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Amount{" +
                "amount=" + amount +
                '}';
    }
}

