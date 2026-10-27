package com.example.corebank.controller;

import com.example.corebank.request.AccountRequest;
import com.example.corebank.response.BaseResponse;
import com.example.corebank.service.AccountService;
import com.example.corebank.service.AccountTransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    private AccountService accountService;
    private AccountTransactionService accountTransactionService;

    public AccountController(AccountService accountService, AccountTransactionService accountTransactionService){
        this.accountService = accountService;
        this.accountTransactionService = accountTransactionService;
    }


    @PostMapping("/findByAccountNumber")
    public ResponseEntity <BaseResponse> findByAccountNumber (@RequestBody AccountRequest accountRequest){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(accountService.findByAccountNumber(accountRequest.getAccountNumber()));
        baseResponse.setCode("200");
        baseResponse.setMessage("lay tai khoan thanh cong");
        return  ResponseEntity.ok(baseResponse);
    }

    @PostMapping("/getBalance")
    public ResponseEntity<BaseResponse> getBalance(@RequestBody AccountRequest accountRequest){
        BaseResponse baseResponse = new BaseResponse();
        Long accountId = accountService.findByAccountNumber(accountRequest.getAccountNumber()).getId();
        baseResponse.setData(accountTransactionService.getBalance(accountId));
        baseResponse.setCode("200");
        baseResponse.setMessage("lay so du tai khoan thanh cong");
        return ResponseEntity.ok(baseResponse);
    }
}
