package com.example.corebank.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CheckAccountResponse {
    private String code;
    private boolean eligible;
    private String message;
}
