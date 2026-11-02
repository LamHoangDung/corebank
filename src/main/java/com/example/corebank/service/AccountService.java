package com.example.corebank.service;


import com.example.corebank.entity.AccountsEntity;
import com.example.corebank.repository.AccountTransactionsRepository;
import com.example.corebank.repository.AccountsRepository;
import com.example.corebank.response.CheckAccountResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AccountService{

    private AccountsRepository accountsRepository;
    private AccountTransactionsRepository accountTransactionsRepository;

    public AccountService(AccountsRepository accountsRepository, AccountTransactionsRepository accountTransactionsRepository){
        this.accountsRepository = accountsRepository;
        this.accountTransactionsRepository = accountTransactionsRepository;
    }

    public AccountsEntity findByAccountNumber(String accountNumber){
        try {
            AccountsEntity result = accountsRepository.findByAccountNumber(accountNumber);
            return result;
        } catch (Exception e) {
            throw new RuntimeException("loi khong tim duoc account" +e.getMessage());
        }
    }

    public CheckAccountResponse checkAccount(String accountNumber, String customerCode, BigDecimal amount){
        if(accountNumber == null || accountNumber.isBlank() || customerCode == null|| customerCode.isBlank()||amount == null|| amount.compareTo(BigDecimal.ZERO) <= 0  ){
            return new CheckAccountResponse("invalid", false, "thong tin nhap vao khong hop le");
        }

        //ktra  ta khoan
        AccountsEntity account = accountsRepository.findByAccountNumber(accountNumber);
        if(account == null){
            return new CheckAccountResponse("invalid", false, "khong tim thay tai khoan");
        }
        if (!customerCode.equals(account.getCustomer().getCustomerCode())) {
            return new CheckAccountResponse(
                    "invalid", false, "tai khoan khong thuoc khach hang"
            );
        }

        //ktra trang thai tai khoan
        if(!"ACTIVE".equals(account.getActivityStatus().getCode())){
            return new CheckAccountResponse("invalid", false, "tai khoan khong hoat dong");
        }

        //ktra so du tai khoan
        BigDecimal balance = accountTransactionsRepository.getBalance(accountNumber);
        if(balance.compareTo(amount)<0){
            return new CheckAccountResponse("invalid", false, "tai khoan khong du so du");
        }
        return  new CheckAccountResponse("valid", true, "tai khoan hop le");
    }






}
