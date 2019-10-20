package com.vergil.Aspect.service.dto;

import com.vergil.Aspect.domain.User;

public class ContaDTO {

    private Long id;
    
    private String descricao;
    
    private Double saldo;
    
    private User user;

    public ContaDTO() {
    }

    public ContaDTO(Long id, String descricao, Double saldo, User user) {
        this.id = id;
        this.descricao = descricao;
        this.saldo = saldo;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ContaDTO{" +
            "id=" + id +
            ", descricao='" + descricao + '\'' +
            ", saldo=" + saldo +
            ", user=" + user +
            '}';
    }
}
