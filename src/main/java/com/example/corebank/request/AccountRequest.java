package com.example.corebank.request;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountRequest {
    private String accountNumber;
    private String customerCode;
}
