package com.vergil.Aspect.web.rest;


import com.vergil.Aspect.domain.Account;
import com.vergil.Aspect.domain.Transaction;
import com.vergil.Aspect.domain.User;
import com.vergil.Aspect.repository.AccountRepository;
import com.vergil.Aspect.repository.TransactionRepository;
import com.vergil.Aspect.repository.UserRepository;
import com.vergil.Aspect.service.UserService;
import com.vergil.Aspect.service.dto.FormUsuarioDTO;
import com.vergil.Aspect.web.rest.errors.EntityNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
public class UserResource {

    private final UserRepository userRepository;
    private final UserService userService;
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public UserResource(UserRepository userRepository, UserService userService, AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @PostMapping("/users")    
    public User newUser(@RequestBody FormUsuarioDTO formUsuarioDTO)throws URISyntaxException {
        User user = userService.gravar(formUsuarioDTO);
        return user;
    }
    @PutMapping("/users")
    public User updateUser(@RequestBody FormUsuarioDTO formUsuarioDTO)throws URISyntaxException {
        User user = userService.atualizar(formUsuarioDTO);
        return user;
    }
    @GetMapping("/users")
    public List<User> findUsers()throws URISyntaxException{
        List<User> user = userRepository.findAll();
        return user;
    }

    @GetMapping("/users/{id}")
    public User findUser(@PathVariable Long id)throws URISyntaxException{
        Optional<User> userTemp= userRepository.findById(id);
        if(userTemp.isPresent()){
            return userTemp.get();
        } else {
            throw new EntityNotFoundException();
        }
    }

    @GetMapping("/users/{id}/account")
    public List<Account> findAllAccountsByUserId(@PathVariable Long id)throws URISyntaxException{
       return accountRepository.buscarAccountPorUserId(id);       
    }

    @GetMapping("/users/{id}/transaction")
    public List<Transaction> findAllTransactionsByUserId(@PathVariable Long id)throws URISyntaxException{
        return transactionRepository.buscarTransacationPorUserId(id);
    }
   
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "deletou";
     }
    
}
