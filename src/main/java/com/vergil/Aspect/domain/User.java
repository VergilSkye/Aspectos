package com.vergil.Aspect.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A User
 */

@Entity
@Table(name = "users")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull
    @Size(max = 255)
    private String name;


    @Column(name = "login", length = 50, unique = true, nullable = false)
    @NotNull
    @Pattern(regexp = "^[_.@A-Za-z0-9-]*$")
    @Size(min = 1, max = 50)
    private String login;

    @Column(name = "password", length = 60, nullable = false)
    @NotNull
    private String password;

    @Email
    @Size(min = 5, max = 191)
    @Column(length = 191, unique = true, nullable = true)
    private String email;


    @Column(name = "fone", length = 15)
    private String fone;

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    @JsonIgnore
    private Instant createdDate = Instant.now();

    @OneToMany(targetEntity = Account.class, mappedBy = "user")
    @OrderBy("description ASC ")
    private Set<Account> accounts = new HashSet<Account>();


    public User() {
    }

    public User(@NotNull @Size(max = 255) String name, @NotNull @Pattern(regexp = "^[_.@A-Za-z0-9-]*$") @Size(min = 1, max = 50) String login, @NotNull String password, @Email @Size(min = 5, max = 191) String email) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFone() { return fone; }

    public void setFone(String fone) { this.fone = fone; }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Set<Account> getAccounts() { return accounts; }

    public void setAccounts(Set<Account> accounts) { this.accounts = accounts; }

    public void addAccount(Account account) {
        this.accounts.add(account);
        account.setUser(this);
    }

    public void removeAccount(Account account) {
        this.accounts.remove(account);
        account.setUser(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) &&
            email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", login='" + login + '\'' +
            ", password='" + password + '\'' +
            ", email='" + email + '\'' +
            ", fone='" + fone + '\'' +
            '}';
    }
}
