package com.selfstudy.accounts.controller;

import com.selfstudy.accounts.constants.AccountConstant;
import com.selfstudy.accounts.dto.AccountDto;
import com.selfstudy.accounts.dto.CustomerDto;
import com.selfstudy.accounts.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountController {

    @GetMapping("sayHello")
    public String sayHello() {
        return "Hello Wolrd";
    }

    @PostMapping("/craete")
    public ResponseEntity<ResponseDto> createAccount(CustomerDto customerDto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountConstant.STATUS_201,
                        AccountConstant.MESSAGE_201));
    }
}
