package com.example.FairytaleFlavors.service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.FairytaleFlavors.bean.Account;
import com.example.FairytaleFlavors.enumClass.AccountRole;
import com.example.FairytaleFlavors.repository.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostConstruct
    public void initialize(){		
        if(accountRepository.findOneByUsername("USER") == null){
            save(new Account("USER", "USER", AccountRole.USER.toString()));
        }
        if(accountRepository.findOneByUsername("USER") == null){
            save(new Account("USER", "USER", AccountRole.USER.toString()));
        }
        if(accountRepository.findOneByUsername("USER") == null){
            save(new Account("USER", "USER", AccountRole.USER.toString()));
        }
    }

    @Transactional
    private Account save(Account user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return accountRepository.save(user);
    }
}