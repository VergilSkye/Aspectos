package com.vergil.Aspect.web.rest;


import com.vergil.Aspect.domain.Account;
import com.vergil.Aspect.domain.Transaction;
import com.vergil.Aspect.repository.AccountRepository;
import com.vergil.Aspect.repository.TransactionRepository;
import com.vergil.Aspect.service.AccountService;
import com.vergil.Aspect.service.dto.ContaDTO;
import com.vergil.Aspect.web.rest.errors.EntityNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
public class AccountResource {
    
    private AccountRepository accountRepository;
    private AccountService accountService;
    private TransactionRepository transactionRepository;

    public AccountResource(AccountRepository accountRepository, AccountService accountService, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.accountService = accountService;
        this.transactionRepository = transactionRepository;
    }

    @PostMapping("/accounts")
    public Account  newAccount(@RequestBody ContaDTO contaDTO)throws URISyntaxException {
        Account acc = accountService.gravar(contaDTO);
        return acc;
    }
    @PutMapping("/accounts")
    public Account  updateUsuario(@RequestBody ContaDTO contaDTO)throws URISyntaxException {
        Account acc = accountService.atualizar(contaDTO);
        return acc;
    }
    @GetMapping("/accounts")
    public List<Account> findUsers()throws URISyntaxException{
        List<Account> acc = accountRepository.findAll();
        return acc;
    }

    @GetMapping("/accounts/{id}")
    public Account findUser(@PathVariable Long id)throws URISyntaxException{
        Optional<Account> accTemp = accountRepository.findById(id);
        if(accTemp.isPresent()){
            return accTemp.get();
        } else {
            throw new EntityNotFoundException();
        }
    }

    @GetMapping("/accounts/{id}/transaction")
    public List<Transaction> findAllTransactionsByAccountId(@PathVariable Long id)throws URISyntaxException{
        return transactionRepository.buscarTransacationPorAccountId(id);
    }  

    @DeleteMapping("/accounts/{id}")
    public String deleteAccount(@PathVariable Long id) {
        accountRepository.deleteById(id);
        return "deletou";
    }
}
