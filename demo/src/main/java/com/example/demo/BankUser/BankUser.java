package com.example.demo.BankUser;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

//The following annotations helps the spring scanning mechanism to identify the entities for our application so that
//it can be used in spring jpa operation
@Entity
@Table
public class BankUser {

//    This annotation will help jpa to decide which property to be used as a primary key
    @Id

//    The following annotation tells jpa how to create the unique values for the primary key
    @SequenceGenerator(
            name = "bankUser_sequence",
            sequenceName = "bankUser_sequence",
            allocationSize = 1  // haven't understood that yet
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,  // Tell the kind of the sequence to use
            generator = "bankUser_sequence"   // the name of the sequence we mentioned in @SequenceGenerator annotation
    )
    private int id;
    private String name;
    private int balance;
    private String accountType;
    private String role;
    private LocalDate createdAt;


    public BankUser(int id, String name, int balance, String accountType, String role, LocalDate createdAt) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.accountType = accountType;
        this.role = role;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
