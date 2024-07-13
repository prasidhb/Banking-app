package com.Banking.Banking.application.service;

import com.Banking.Banking.application.dto.AccountDto;


public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(long id);

    AccountDto deposit(Long id, double amount);

    void deleteAccount(Long id);






}
