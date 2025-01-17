package com.avanade.simple_bank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avanade.simple_bank.repositories.TransacaoRepository;
import com.avanade.simple_bank.entities.Transacao;

import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    public List<Transacao> listarTransacao() {
        return transacaoRepository.findAll();
    }

    public Transacao efetuarTransacao(Transacao transacao) {
        return transacaoRepository.save(transacao);
    }
}
