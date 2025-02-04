package com.avanade.simple_bank.dto;

import java.util.UUID;

public class ClienteDTO {
    private UUID id;
    private String nome;
    private String endereco;
    private int tipoConta;
    private int ativa;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(int tipoConta) {
        this.tipoConta = tipoConta;
    }

    public int getAtiva() {
        return ativa;
    }

    public void setAtiva(int ativa) {
        this.ativa = ativa;
    }
}