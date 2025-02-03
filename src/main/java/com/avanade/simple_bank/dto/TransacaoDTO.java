package com.avanade.simple_bank.dto;

import java.util.UUID;

public class TransacaoDTO {
    private UUID contaOrigem;
    private UUID contaDestino;
    private int tipoTransacao;
    private String dataTransacao;
    private double valor;
    private String descricao;


    public UUID getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(UUID contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public UUID getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(UUID contaDestino) {
        this.contaDestino = contaDestino;
    }

    public int getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(int tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public String getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(String dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
