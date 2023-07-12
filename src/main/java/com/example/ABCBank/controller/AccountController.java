package com.example.ABCBank.controller;

import com.example.ABCBank.bankingobjects.Account;
import com.example.ABCBank.bankingobjects.Ammount;
import com.example.ABCBank.Repositories.AccountRepository;
import com.example.ABCBank.model.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class AccountController {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    

    @PostMapping("/createacc")
    public ResponseEntity<Account> createAccount(@RequestBody Account account ) {
        accountRepository.save(account);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

    @PostMapping("/{accountId}/withdraw")
    public ResponseEntity<String> withdrawFunds(@PathVariable("accountId") long accountId,
                                                @RequestBody Ammount ammount) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        double currentBalance = account.getBalance();
        double withdrawalAmount = ammount.getAmount();

        if (currentBalance >= withdrawalAmount) {
            account.setBalance(currentBalance - withdrawalAmount);
            accountRepository.save(account);
            return ResponseEntity.ok("Funds withdrawn successfully");
        } else {
            return ResponseEntity.badRequest().body("Insufficient funds");
        }
    }

    @GetMapping("/acc")
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return ResponseEntity.ok(accounts);
    }



}
