package com.avanade.simple_bank.services;

import com.avanade.simple_bank.entities.Transacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avanade.simple_bank.repositories.TransacaoRepository;
import com.avanade.simple_bank.entities.Conta;
import com.avanade.simple_bank.repositories.ContaRepository;

import java.util.List;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;
    @Autowired
    private TransacaoRepository transacaoRepository;

    public List<Conta> listarConta() {
        return contaRepository.findAll();
    }

    public Conta listarContaId(String contaId) {
        return contaRepository.findById(contaId)
                .orElseThrow(() -> new IllegalArgumentException("Conta não encontrada"));
    }

    public Conta criarConta(Conta conta) {
        return contaRepository.save(conta);
    }

}
