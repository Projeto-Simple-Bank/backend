package com.avanade.simple_bank.services;

import com.avanade.simple_bank.entities.Boleto;
import com.avanade.simple_bank.entities.Conta;
import com.avanade.simple_bank.repositories.BoletoRepository;

import com.avanade.simple_bank.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoletoService {

    @Autowired
    private BoletoRepository boletoRepository;

    @Autowired
    private ContaRepository contaRepository;

    public Conta findById(int id) {
        return contaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Conta não encontrada"));
    }


    public Boleto criarBoleto(Boleto boleto) {
        return boletoRepository.save(boleto);
    }

    public void pagarBoleto(Boleto boleto) {
        Boleto codigoBoleto = boletoRepository.findByCodigoDeBarras(boleto.getCodigo());
        Conta conta = findById(boleto.getConta().getId());

        if(codigoBoleto == null){
            throw new IllegalArgumentException("Boleto não encontrado.");
        }

        if (conta.getSaldo() < codigoBoleto.getValor() ) {
            throw new IllegalArgumentException("Saldo insuficiente!");
        }

        Boleto boletoPago = new Boleto();
        boletoPago.setId(boleto.getId());
        boletoPago.setCodigo(boleto.getCodigo());
        boletoPago.setBeneficiario(boleto.getBeneficiario());
        boletoPago.setValor(boleto.getValor());
        boletoPago.setStatusBoleto(true);
        boletoPago.setConta(boleto.getConta());

        contaRepository.save(conta);
        boletoRepository.save(boletoPago);

    }

}
