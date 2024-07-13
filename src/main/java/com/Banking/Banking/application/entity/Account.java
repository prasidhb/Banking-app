package com.Banking.Banking.application.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@Table(name="accounts")
@Entity
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;


    @Column(name="account_holder_name")
    private String accountHolderName;
    
    private Double balance;

    public Account(long id, String accountHolderName, double balance) {
        this.id = id;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }


    public long getId() {
            return id;
    }
    
    public void setId(long id) {
            this.id = id;
    }       
    
    public String getAccountHolderName() {
            return accountHolderName;
    }
    
    public void setAccountHolderName(String accountHolderName) {
            this.accountHolderName = accountHolderName;
    }   
    
    public Double getBalance() {
            return balance;
    }
        
    public void setBalance(Double balance) {
        this.balance = balance;
        
    }
}
