package com.selfstudy.accounts.repository;

import com.selfstudy.accounts.entity.Account;
import com.selfstudy.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
}
