package com.example.corebank.service;


import com.example.corebank.entity.AccountsEntity;
import com.example.corebank.repository.AccountsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService{

    private AccountsRepository accountsRepository;

    public AccountService(AccountsRepository accountsRepository){
        this.accountsRepository = accountsRepository;
    }

    public AccountsEntity findByAccountNumber(String accountNumber){
        try {
            Optional<AccountsEntity> result = accountsRepository.findByAccountNumber(accountNumber);
            if(result.isPresent()){
                return result.get();
            }
            System.out.println("khong tim thay account nao");
            return null;
        } catch (Exception e) {
            throw new RuntimeException("loi khong tim duoc account" +e.getMessage());
        }
    }

}
