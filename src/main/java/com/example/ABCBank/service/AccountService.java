package com.example.ABCBank.service;

import com.example.ABCBank.Repositories.AccountRepository;
import com.example.ABCBank.Repositories.UserRepository;
import com.example.ABCBank.bankingobjects.Account;
import com.example.ABCBank.config.JwtService;
import com.example.ABCBank.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private JwtService jwtService;


    public User createAccount(User user, Account account){

        List<Account> accounts = user.getAccounts();
        accounts.add(account);
        user.setAccounts(accounts);
        return userRepository.save(user);

    }

    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    public List<Account> getUserAccount(User user){
        List<Account> accounts =user.getAccounts();
        return accounts;

    }

}
