package com.avanade.simple_bank.services;

import com.avanade.simple_bank.entities.Transacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avanade.simple_bank.repositories.TransacaoRepository;
import com.avanade.simple_bank.entities.Conta;
import com.avanade.simple_bank.repositories.ContaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    public List<Conta> listarConta() {
        return contaRepository.findAll();
    }

    public Conta listarContaId(int contaId) {
        return contaRepository.findById(contaId)
                .orElseThrow(() -> new IllegalArgumentException("Conta não encontrada"));
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

//    atualizacao do transacao na conta do cliente
//    public Conta atualizarSaldo(int contaId, Transacao transacao){
//        Conta conta = contaRepository.findById(contaId)
//                .orElseThrow(() -> new IllegalArgumentException("Conta não encontrada"));
//        if(transacao.getTipoOperacao() == 1){
//            if (conta.getSaldo() < transacao.getValor()){
//                throw new IllegalArgumentException("Saldo insuficiente");
//            }
//            conta.setSaldo(conta.getSaldo() - transacao.getValor());
//        }else if(transacao.getTipoOperacao() == 2){
//            conta.setSaldo(conta.getSaldo() + transacao.getValor());
//        }
//        transacao.setConta(conta);
//        contaRepository.save(conta);
//        transacaoRepository.save(transacao);
//
//        return conta;
//    }
}
