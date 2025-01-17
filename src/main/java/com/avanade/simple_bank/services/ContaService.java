package com.avanade.simple_bank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avanade.simple_bank.entities.Conta;
import com.avanade.simple_bank.repositories.ContaRepository;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public List<Conta> listarContas() {
        return contaRepository.findAll();
    }

    public Conta incluirConta(Conta conta) {
        return contaRepository.save(conta);
    }
}