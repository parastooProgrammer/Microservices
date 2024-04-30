package com.selfstudy.accounts.service;

import com.selfstudy.accounts.dto.CustomerDto;

public interface IAccountService {
    /**
     *
     * @param customerDto
     */
    void createAccount(CustomerDto customerDto);
    CustomerDto fetchAccount(String mobileNumber);
}
