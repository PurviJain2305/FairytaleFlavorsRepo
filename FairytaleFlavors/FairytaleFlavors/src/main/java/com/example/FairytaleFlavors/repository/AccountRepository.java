package com.example.FairytaleFlavors.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FairytaleFlavors.bean.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findOneByUsername(String username);
}