package com.Banking.Banking.application.repository;

import com.Banking.Banking.application.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}