package com.example.corebank.repository;

import com.example.corebank.entity.AccountTransactionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface AccountTransactionsRepository extends JpaRepository<AccountTransactionsEntity, Long> {


    @Query("""
        SELECT COALESCE(SUM(t.amount), 0)
        FROM account_transactions t
        JOIN t.accounts a
        JOIN t.transactionStatus s
        WHERE a.id = :accountId
          AND s.code = 'SUCCESS'
        """)
    BigDecimal getBalance(@Param("accountId") Long accountId);
}