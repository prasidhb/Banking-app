package com.Banking.Banking.application.service.impl;

import com.Banking.Banking.application.Mapper.AccountMapper;
import com.Banking.Banking.application.dto.AccountDto;
import com.Banking.Banking.application.entity.Account;
import com.Banking.Banking.application.repository.AccountRepository;
import com.Banking.Banking.application.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceimpl implements AccountService{

private AccountRepository accountRepository;

    public AccountServiceimpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }



    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount  = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(long id) {

        Account account = accountRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("account doest not exists"));

        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("account doest not exists"));


        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount  = accountRepository.save(account);


        return AccountMapper.mapToAccountDto(savedAccount);
    }



    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("account doest not exists"));

        accountRepository.deleteById(id);






    }


}

