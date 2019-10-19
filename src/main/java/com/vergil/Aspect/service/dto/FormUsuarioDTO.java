package com.vergil.Aspect.service.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class FormUsuarioDTO {

    private Long id;
   
    @NotNull
    @Size(max = 255)
    private String nome;

    @NotNull
    @Pattern(regexp = "^[_.@A-Za-z0-9-]*$")
    @Size(min = 1, max = 50)
    private String login;

    @NotNull
    @Size(min = 1, max = 60)
    private String senha;

    @Email
    @Size(min = 5, max = 191)
    private String email;
    
    @Size(min = 8, max = 15)
    private String fone;

    public FormUsuarioDTO() {
    }

    public FormUsuarioDTO(@NotNull @Size(max = 255) String nome, @NotNull @Pattern(regexp = "^[_.@A-Za-z0-9-]*$") @Size(min = 1, max = 50) String login, @NotNull @Size(min = 1, max = 60) String senha, @Email @Size(min = 5, max = 191) String email, @Size(min = 8, max = 15) String fone) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.fone = fone;
    }

    public FormUsuarioDTO(Long id, @NotNull @Size(max = 255) String nome, @NotNull @Pattern(regexp = "^[_.@A-Za-z0-9-]*$") @Size(min = 1, max = 50) String login, @NotNull @Size(min = 1, max = 60) String senha, @Email @Size(min = 5, max = 191) String email, @Size(min = 8, max = 15) String fone) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.fone = fone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    @Override
    public String toString() {
        return "FormUsuarioDTO{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            ", login='" + login + '\'' +
            ", senha='" + senha + '\'' +
            ", email='" + email + '\'' +
            ", fone='" + fone + '\'' +
            '}';
    }
}

