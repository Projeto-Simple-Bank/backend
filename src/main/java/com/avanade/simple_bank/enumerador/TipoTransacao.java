package com.avanade.simple_bank.enumerador;

// vou ter que ajustar esse enum
public enum TipoTransacao {
    PIX(1),
    TED(2),
    BOLETO(3);

    private int codigo;

    TipoTransacao(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}
