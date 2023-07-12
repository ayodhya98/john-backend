package com.example.ABCBank.bankingobjects;

import com.example.ABCBank.model.User;
import com.fasterxml.jackson.annotation.JacksonInject;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "Accounts")
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double balance;
    private String accountNumber;

    @Column(name = "id", nullable = false)
    public long getUserId(){
        return id;}

    @Column(name = "Balance", nullable = false)
    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}

