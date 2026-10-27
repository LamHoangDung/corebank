package com.example.corebank.response;


import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.ObjectMapper;

@Setter
@Getter
public class BaseResponse {
    private String code;
    private Object data;
    private String message;
}
