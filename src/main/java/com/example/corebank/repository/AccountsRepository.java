package com.example.corebank.repository;

import com.example.corebank.entity.AccountsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository<AccountsEntity, Long> {
    AccountsEntity findByAccountNumber(String accountNumber);
}
