package com.vergil.Aspect.service;


import com.vergil.Aspect.domain.Account;
import com.vergil.Aspect.repository.AccountRepository;
import com.vergil.Aspect.repository.UserRepository;
import com.vergil.Aspect.service.dto.ContaDTO;
import com.vergil.Aspect.web.rest.errors.BadRequestAlertException;
import com.vergil.Aspect.web.rest.errors.EntityNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Service class for managing accounts.
 */
@Service
@Transactional
public class AccountService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;   

    public AccountService(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    public Account gravar(ContaDTO contaDTO){
        if (contaDTO.getId() != null) {
            throw new BadRequestAlertException("A new user cannot already have an ID", null, "idexists");
        }
        Account acc = convertContaToAccount(contaDTO);
        return accountRepository.save(acc);
    }
    public Account atualizar(ContaDTO contaDTO){
        Account oldAcc = null;
        if (contaDTO.getId() != null) {
           Optional<Account> tempAcc= accountRepository.findById(contaDTO.getId());
           if(tempAcc.isPresent()){
               oldAcc = tempAcc.get();
           } else {
               throw new EntityNotFoundException();
           }            
        } else {
            Optional<Account> tempAcc = accountRepository.findAccountByDescriptionIgnoreCase(contaDTO.getDescricao());
            if(tempAcc.isPresent()){
                oldAcc = tempAcc.get();
            } else {
                throw new EntityNotFoundException();
            }
        }
        
        oldAcc.setDescription(contaDTO.getDescricao());
        oldAcc.setBalance(contaDTO.getSaldo());
        oldAcc.setUser(contaDTO.getUser());
        
        return accountRepository.save(oldAcc);
     
        
    }
    
    
    Account convertContaToAccount(ContaDTO contaDTO){
        Account acc = new Account();
        acc.setId(contaDTO.getId());
        acc.setDescription(contaDTO.getDescricao());
        acc.setBalance(contaDTO.getSaldo());
        acc.setUser(contaDTO.getUser());
        return acc;
    }
}
