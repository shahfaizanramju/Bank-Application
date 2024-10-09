package com.example.bankapp.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor // Add a no-args constructor for JPA
@AllArgsConstructor // Keep this for convenience
@Table(name = "transactions") // Ensure the table name is correct
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount; // Ensure 'amount' is declared as private
    private BigDecimal balance;
    private String type;
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "account_id") // Correct spelling for foreign key
    private Account account;

    public Transaction(BigDecimal amount, BigDecimal balance, String type, LocalDateTime timestamp, Account account) {
        this.amount = amount; // Set the amount correctly
        this.balance = balance; // Use the correct parameter name
        this.type = type;
        this.timestamp = timestamp;
        this.account = account;
    }
}