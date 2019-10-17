package com.vergil.Aspect.repository;

import com.vergil.Aspect.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByName(String name);
    Optional<User> findByLogin(String login);
    Optional<User> findByEmail(String email);
    
}
