package com.vergil.Aspect.repository;

import com.vergil.Aspect.domain.Account;
import com.vergil.Aspect.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("select a from Account a where a.user.id =(?1)")
    List<Account> buscarAccountPorUserId(Long id);
    
    List<Account> findAccountByUser(User user);
    
}
