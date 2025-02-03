package com.avanade.simple_bank.enumerations;

// vou ter que ajustar esse enum
public enum TipoConta {
    NORMAL(1),
    ESPECIAL(2);

    private int codigo;

    TipoConta(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}