package com.Banking.Banking.application.dto;


import lombok.*;

@Data
public class AccountDto {

    private Long id;

    private String accountHolderName;

    private double balance;


    public AccountDto(long id, String accountHolderName, Double balance) {
        this.id = id;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public long getId() {
            return id;

    }
    public String getAccountHolderName() {
        return accountHolderName;

    }

    public double getBalance() {
        return balance;

    }


}
