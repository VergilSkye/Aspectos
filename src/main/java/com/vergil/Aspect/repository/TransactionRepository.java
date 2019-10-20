package com.vergil.Aspect.repository;

import com.vergil.Aspect.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("select a from Transaction a where a.account.id =(?1)")
    List<Transaction> buscarTransacationPorAccountId(Long id);

    @Query("select a from Transaction a where a.account.user.id =(?1)")
    List<Transaction> buscarTransacationPorUserId(Long id);
}
