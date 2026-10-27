package com.example.corebank.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity(name = "accounts")
public class AccountsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountNumber;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomersEntity customer;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private BranchesEntity branches;

    @ManyToOne
    @JoinColumn(name = "activity_status")
    private  ActivityStatusEntity activityStatus;

    private LocalDateTime createdAt;
}
