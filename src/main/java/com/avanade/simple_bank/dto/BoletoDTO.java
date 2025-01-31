package com.avanade.simple_bank.dto;

import java.util.UUID;

public class BoletoDTO {
    private UUID contaId;
    private String codigo;
    private double valor;
    private String dataVencimento;
    private String dataTransacao;
    private boolean statusBoleto;
    private String beneficiario;

    public UUID getContaId() {
        return contaId;
    }

    public void setContaId(UUID contaId) {
        this.contaId = contaId;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public boolean isStatusBoleto() {
        return statusBoleto;
    }

    public void setStatusBoleto(boolean statusBoleto) {
        this.statusBoleto = statusBoleto;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    public String getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(String dataTransacao) {
        this.dataTransacao = dataTransacao;
    }
}
