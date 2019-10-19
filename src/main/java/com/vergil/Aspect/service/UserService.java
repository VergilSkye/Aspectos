package com.vergil.Aspect.service;


import com.vergil.Aspect.domain.User;
import com.vergil.Aspect.repository.UserRepository;
import com.vergil.Aspect.service.dto.FormUsuarioDTO;
import com.vergil.Aspect.web.rest.errors.BadRequestAlertException;
import com.vergil.Aspect.web.rest.errors.EmailAlreadyUsedException;
import com.vergil.Aspect.web.rest.errors.EntityNotFoundException;
import com.vergil.Aspect.web.rest.errors.LoginAlreadyUsedException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Service class for managing users.
 */
@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User gravar(FormUsuarioDTO form) {
        if (form.getId() != null) {
            throw new BadRequestAlertException("A new user cannot already have an ID", null, "idexists");
        }

        userRepository.findByLogin(form.getLogin()).ifPresent(old_user -> {
            throw new LoginAlreadyUsedException();
        });
        userRepository.findByEmailIgnoreCase(form.getEmail()).ifPresent(old_user -> {
            throw new EmailAlreadyUsedException();
        });

        // String encryptedPassword = passwordEncoder.encode(password);
        User user = convertFormToUser(form);
        User newUser = userRepository.save(user);
        return newUser;
    }

    public User atualizar(FormUsuarioDTO form) {

        Optional<User> existenteUsuario = userRepository.findByEmailIgnoreCase(form.getEmail());
        if(existenteUsuario.isPresent() && (!existenteUsuario.get().getId().equals(form.getId()))){
            throw new EmailAlreadyUsedException();
        }
        existenteUsuario = userRepository.findByLogin(form.getLogin());
        if(existenteUsuario.isPresent() && (!existenteUsuario.get().getId().equals(form.getId()))){
            throw new EmailAlreadyUsedException();
        }
        
        Optional<User> oldUser = userRepository.findById(form.getId());
        if(oldUser.isPresent()){
            User user = oldUser.get();
            user.setLogin(form.getLogin());
            user.setPassword(form.getSenha());
            user.setName(form.getNome());
            user.setEmail(form.getEmail());
            user.setFone(form.getFone());
            User updatedUser = userRepository.save(user);
            return updatedUser;
            
        } else {
            throw new EntityNotFoundException();
        }     
       

        
    }
    
    
    User convertFormToUser(FormUsuarioDTO formUsuarioDTO){
        User user = new User();
        user.setLogin(formUsuarioDTO.getLogin());
        user.setPassword(formUsuarioDTO.getSenha());
        user.setName(formUsuarioDTO.getNome());
        user.setEmail(formUsuarioDTO.getEmail());
        user.setFone(formUsuarioDTO.getFone());
        return user;
        
    }
}

