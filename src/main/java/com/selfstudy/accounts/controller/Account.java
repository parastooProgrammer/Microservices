package com.selfstudy.accounts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Account {
    @GetMapping("sayHello")
    public String sayHello(){
        return "Hello Wolrd";
    }
}
