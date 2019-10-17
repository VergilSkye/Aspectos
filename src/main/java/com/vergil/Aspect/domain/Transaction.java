package com.vergil.Aspect.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vergil.Aspect.domain.enumaration.TransactionType;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "transactions")
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private TransactionType type;

    @Column(name="amount")
    private Double amount;

    @Column(name="description")
    private Double description;

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    @JsonIgnore
    private Instant createdDate = Instant.now();

    @Column(name = "end_date")
    @JsonIgnore
    private Instant endDate = Instant.now();
    
    @Column(name="was_ended")
    @JsonIgnore
    private Boolean wasEnded;

    @JsonIgnore
    @ManyToOne(optional=false)
    @JoinColumn(name="account_id")
    private Account account;

    public Transaction() {
    }

    public Transaction(TransactionType type, Double amount, Double description, Instant createdDate, Instant endDate, Boolean wasEnded, Account account) {
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.createdDate = createdDate;
        this.endDate = endDate;
        this.wasEnded = wasEnded;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getDescription() {
        return description;
    }

    public void setDescription(Double description) {
        this.description = description;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }

    public Boolean getWasEnded() {
        return wasEnded;
    }

    public void setWasEnded(Boolean wasEnded) {
        this.wasEnded = wasEnded;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Transaction{" +
            "id=" + id +
            ", type=" + type +
            ", amount=" + amount +
            ", description=" + description +
            ", createdDate=" + createdDate +
            ", endDate=" + endDate +
            ", wasEnded=" + wasEnded +
            ", account=" + account +
            '}';
    }
}
