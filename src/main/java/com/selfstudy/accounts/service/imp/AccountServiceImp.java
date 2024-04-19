package com.selfstudy.accounts.service.imp;

import com.selfstudy.accounts.constants.AccountConstant;
import com.selfstudy.accounts.dto.CustomerDto;
import com.selfstudy.accounts.entity.Account;
import com.selfstudy.accounts.entity.Customer;
import com.selfstudy.accounts.mapper.CustomerMapper;
import com.selfstudy.accounts.repository.AccountRepository;
import com.selfstudy.accounts.repository.CustomerRepository;
import com.selfstudy.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

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
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        Customer savedCustomer = customerRepository.save(customer);
        Account account = createNewAccount(savedCustomer);

    }

    /**
     * @param customer
     * @return
     */
    private Account createNewAccount(Customer customer) {
        Account newAccount = new Account();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountConstant.SAVINGS);
        newAccount.setBranchAddress(AccountConstant.ADDRESS);
        return newAccount;
    }
}
