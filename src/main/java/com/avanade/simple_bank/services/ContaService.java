package com.avanade.simple_bank.services;

import com.avanade.simple_bank.entities.Transacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avanade.simple_bank.repositories.TransacaoRepository;
import com.avanade.simple_bank.entities.Conta;
import com.avanade.simple_bank.repositories.ContaRepository;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    public Conta listarContaId(UUID contaId) {
        return contaRepository.findById(contaId)
                .orElseThrow(() -> new IllegalArgumentException("Conta não encontrada"));
    }

    public Conta listarNumeroConta(String numeroConta) {
        if (numeroConta == null){
            throw new IllegalArgumentException("Conta não existe.");
        }

        return contaRepository.findByConta(numeroConta);
    }

    public Conta criarConta(Conta conta) {
        return contaRepository.save(conta);
    }

    public Optional<Conta> autenticar(String conta, String senha) {
        Conta contaEncontrada = contaRepository.findByConta(conta);

        if (contaEncontrada != null && contaEncontrada.getSenha().equals(senha)) {
            return Optional.of(contaEncontrada);
        }
        return Optional.empty();
    }
}
