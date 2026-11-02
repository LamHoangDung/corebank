package com.example.corebank.controller;

import com.example.corebank.request.CheckAccountRequest;
import com.example.corebank.response.BaseResponse;
import com.example.corebank.response.CheckAccountResponse;
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
    public ResponseEntity <BaseResponse> findByAccountNumber (@RequestBody CheckAccountRequest checkAccountRequest){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(accountService.findByAccountNumber(checkAccountRequest.getAccountNumber()));
        baseResponse.setCode("200");
        baseResponse.setMessage("lay tai khoan ");
        return  ResponseEntity.ok(baseResponse);
    }

    @PostMapping("/getBalance")
    public ResponseEntity<BaseResponse> getBalance(@RequestBody CheckAccountRequest accountRequest){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(accountTransactionService.getBalance(accountRequest.getAccountNumber()));
        baseResponse.setCode("200");
        baseResponse.setMessage("lay so du tai khoan");
        return ResponseEntity.ok(baseResponse);
    }

    @PostMapping("/check")
    public  ResponseEntity<CheckAccountResponse> checkAccount(@RequestBody CheckAccountRequest checkAccountRequest){
        CheckAccountResponse checkAccountResponse = accountService.checkAccount(checkAccountRequest.getAccountNumber(), checkAccountRequest.getCustomerCode(), checkAccountRequest.getAmount());
        return ResponseEntity.ok(checkAccountResponse);
    }
}
