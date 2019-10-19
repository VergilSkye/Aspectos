package com.vergil.Aspect.web.rest;


import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import com.vergil.Aspect.domain.Account;
import com.vergil.Aspect.domain.User;
import com.vergil.Aspect.repository.AccountRepository;
import com.vergil.Aspect.repository.UserRepository;
import com.vergil.Aspect.service.UserService;
import com.vergil.Aspect.service.dto.FormUsuarioDTO;
import com.vergil.Aspect.web.rest.errors.BadRequestAlertException;
import com.vergil.Aspect.web.rest.errors.EntityNotFoundException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserResource {

    private final UserRepository userRepository;
    private final UserService userService;
    private final AccountRepository accountRepository;

    public UserResource(UserRepository userRepository, UserService userService, AccountRepository accountRepository ) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.accountRepository = accountRepository;
    }

    /**
     * {@code POST  /users}  : Creates a new user.
     * <p>
     * Creates a new user if the login and email are not already used, and sends an
     * mail with an activation link.
     * The user needs to be activated on creation.
     *
     * @param formUsuarioDTO the user to create.
     * @return the {@link User}  with body the new user, or a error  if the login or email is already in use.
     * @throws java.net.URISyntaxException if the Location URI syntax is incorrect.
     * @throws BadRequestAlertException  if the login or email is already in use.
     */
    @PostMapping("/users")    
    public User newUsuario(@RequestBody FormUsuarioDTO formUsuarioDTO)throws URISyntaxException {
        User user = userService.gravar(formUsuarioDTO);
        return user;
    }

    /**
     * {@code PUT  /users}  : Creates a new user.
     * <p>
     * Updates a old user if the login and email are not already used
     *
     * @param formUsuarioDTO the user to create.
     * @return the {@link User}  with body the new user, or a error  if the login or email is already in use.
     * @throws java.net.URISyntaxException if the Location URI syntax is incorrect.
     * @throws BadRequestAlertException  if the login or email is already in use.
     */
    @PutMapping("/users")
    public User updateUsuario(@RequestBody FormUsuarioDTO formUsuarioDTO)throws URISyntaxException {
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
   
    @DeleteMapping("/users/{id}")
    public String deleteBaixaEstoque(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "deletou";
     }


    
    
}
