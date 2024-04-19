package com.selfstudy.accounts.service.imp;

import com.selfstudy.accounts.dto.CustomerDto;
import com.selfstudy.accounts.repository.AccountRepository;
import com.selfstudy.accounts.repository.CustomerRepository;
import com.selfstudy.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImp implements IAccountService {
    //to see the methods press ctrl+f12
    private CustomerRepository customerRepository;
    private AccountRepository accountRepository;
    /**
     * @param customerDto
     */
    @Override
    public void createAccount(CustomerDto customerDto) {

    }
}
