package com.Banking.Banking.application.controller;


import com.Banking.Banking.application.dto.AccountDto;
import com.Banking.Banking.application.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //add account restapi

    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    //get account restapi

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable long id){
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);

    }

    //deposit the account
@PutMapping("/{id}/deposit")
    public ResponseEntity<?> deposit(@PathVariable long id,
                                              @RequestBody Map<String,Double> request){


        Double amount  = request.get("amount");
        AccountDto accountDto = accountService.deposit(id,amount);

       return ResponseEntity.ok(accountDto);
    }


    //delete account restapi

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account deleted sucessfully");
    }


}
