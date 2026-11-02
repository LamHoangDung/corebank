package com.example.corebank.repository;

import com.example.corebank.entity.AccountTransactionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface AccountTransactionsRepository extends JpaRepository<AccountTransactionsEntity, Long> {
    @Query(value = "SELECT COALESCE(SUM(t.amount),0)\n" +
            "        FROM account_transactions t\n" +
            "        JOIN accounts a on t.account_id  = a.id\n" +
            "        JOIN transaction_status s on t.transaction_status  = s.code\n" +
            "        WHERE a.account_number = :accountNumber\n" +
            "          AND s.code = 'SUCCESS'\n",nativeQuery = true )
    BigDecimal getBalance(@Param("accountNumber") String accountNumber);
}