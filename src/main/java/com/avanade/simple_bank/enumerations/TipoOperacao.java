package com.avanade.simple_bank.enumerations;

// vou ter que ajustar esse enum
public enum TipoOperacao {
    DEBITO(1),
    CREDITO(2);

    private int codigo;

    TipoOperacao(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}