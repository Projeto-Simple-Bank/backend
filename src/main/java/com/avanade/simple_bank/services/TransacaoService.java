package com.avanade.simple_bank.services;

import com.avanade.simple_bank.dto.TransacaoDTO;
import com.avanade.simple_bank.entities.Conta;
import com.avanade.simple_bank.repositories.ContaRepository;
import com.avanade.simple_bank.repositories.PixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avanade.simple_bank.repositories.TransacaoRepository;
import com.avanade.simple_bank.entities.Transacao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private PixRepository pixRepository;

    public Conta findById(UUID id) {
        return contaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Conta não encontrada"));
    }

    public Transacao listarTransacaoPorId(Transacao transacao) {
        return transacaoRepository.findById(transacao.getId())
                .orElseThrow(() -> new IllegalArgumentException("Transação não encontrada"));
    }

    public List<Transacao> listarTransacoes(Conta conta) {
        Conta findConta = findById(conta.getId());

        if (findConta != null) {
            return transacaoRepository.listarTransacaoPorConta(findConta.getId());
        }
        throw new IllegalArgumentException("Conta não encontrada ou não há transações associadas.");
    }

    // O Transactional serve para fazer com que a requisição de efetuar pagamento funcione
    // até porque aqui é usado mais de um repository
    // (ex: contaRepository que é de conta), então ajuda que os
    // repository de outros lugares funcione reunido dentro de um lugar só
    @Transactional
    public UUID efetuarPagamento(TransacaoDTO transacaoDTO) {
        Conta contaOrigem = findById(transacaoDTO.getContaOrigem());
        Conta contaDestino = findById(transacaoDTO.getContaDestino());

        if (contaOrigem.getSaldo() < (transacaoDTO.getValor() + transacaoDTO.getValor() * 0.05)) {
            throw new IllegalArgumentException("Saldo insuficiente!");
        }
        if (transacaoDTO.getTipoTransacao() == 1) {
            contaOrigem.setSaldo(contaOrigem.getSaldo() - transacaoDTO.getValor());
        }

        if (transacaoDTO.getTipoTransacao() == 2) {
            contaOrigem.setSaldo(contaOrigem.getSaldo() - transacaoDTO.getValor() - (transacaoDTO.getValor() * 0.05));
        }

        contaDestino.setSaldo(contaDestino.getSaldo() + transacaoDTO.getValor());

        Transacao transacaoOrigem = new Transacao();
        transacaoOrigem.setConta(contaOrigem);
        transacaoOrigem.setTipoTransacao(transacaoDTO.getTipoTransacao());
        transacaoOrigem.setValor(transacaoDTO.getValor());
        transacaoOrigem.setDataTransacao(transacaoDTO.getDataTransacao());
        transacaoOrigem.setDescricao(transacaoDTO.getDescricao());

        Transacao transacaoDestino = new Transacao();
        transacaoDestino.setConta(contaDestino); // acho que ao enviar aqui retorna a chavePix
        transacaoDestino.setTipoTransacao(transacaoDTO.getTipoTransacao());
        transacaoDestino.setValor(transacaoDTO.getValor());
        transacaoDestino.setDataTransacao(transacaoDTO.getDataTransacao());
        transacaoDestino.setDescricao(transacaoDTO.getDescricao());

        contaRepository.save(contaOrigem);
        contaRepository.save(contaDestino);
        transacaoRepository.save(transacaoOrigem);
        transacaoRepository.save(transacaoDestino);

        return transacaoOrigem.getId();
    }
}
