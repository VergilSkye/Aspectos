package com.vergil.Aspect.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="accounts")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="description", length = 60)
    private String description;
    
    @Column(name="balance")
    private Double balance;

    @JsonIgnore   
    @ManyToOne(optional=false)
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(targetEntity = Transaction.class, mappedBy = "account")
    @OrderBy("description ")
    private Set<Transaction> transactions = new HashSet<Transaction>();

    public Account() {
    }

    public Account(String description, Double balance, User user) {
        this.description = description;
        this.balance = balance;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Transaction> getTransaction() {
        return transactions;
    }

    public void setTransaction(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void addTransaction(Transaction transaction){
        this.transactions.add(transaction);
        transaction.setAccount(this);
    }
    public void removeTransaction(Transaction transaction){
        this.transactions.remove(transaction);
        transaction.setAccount(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Account{" +
            "id=" + id +
            ", description='" + description + '\'' +
            ", balance=" + balance +
            ", user=" + user +
            '}';
    }
}
