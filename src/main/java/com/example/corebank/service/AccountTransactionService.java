package com.example.corebank.service;

import com.example.corebank.repository.AccountTransactionsRepository;
import com.example.corebank.repository.AccountsRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountTransactionService {


    private AccountTransactionsRepository accountTransactionsRepository;

    public AccountTransactionService(AccountTransactionsRepository accountTransactionsRepository){
        this.accountTransactionsRepository = accountTransactionsRepository;
    }

    public BigDecimal getBalance(Long accountId){
        try {
            return accountTransactionsRepository.getBalance(accountId);
        } catch (Exception e) {
            throw new RuntimeException("loi khong lay dc so du tai khoan" +e.getMessage());
        }
    }

}
