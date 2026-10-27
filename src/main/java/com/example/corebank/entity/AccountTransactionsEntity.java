package com.example.corebank.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity (name = "account_transactions")
public class AccountTransactionsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String transactionCode;
    private String requestId;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private AccountsEntity accounts;

    @ManyToOne
    @JoinColumn(name = "source_account_id")
    private AccountsEntity sourceAccounts;

    @ManyToOne
    @JoinColumn(name = "destination_account_id")
    private AccountsEntity destinationAccounts;

    private String transactionType;

    @ManyToOne
    @JoinColumn(name = "transaction_status")
    private TransactionStatusEntity transactionStatus;

    private BigDecimal amount;
    private String description;
    private LocalDateTime createdAt;


}
