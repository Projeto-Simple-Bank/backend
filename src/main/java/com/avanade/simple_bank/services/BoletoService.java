package com.avanade.simple_bank.services;

import com.avanade.simple_bank.dto.BoletoDTO;
import com.avanade.simple_bank.entities.Boleto;
import com.avanade.simple_bank.entities.Conta;
import com.avanade.simple_bank.entities.Transacao;
import com.avanade.simple_bank.repositories.BoletoRepository;

import com.avanade.simple_bank.repositories.ContaRepository;
import com.avanade.simple_bank.repositories.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BoletoService {

    @Autowired
    private BoletoRepository boletoRepository;

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    public List<Boleto> listarBoletos() {
        return boletoRepository.findAll();
    }

    public Boleto listarBoletoByCodigo(String codigo) {
        return boletoRepository.findByCodigoDeBarras(codigo);
    }

    public Boleto criarBoleto(Boleto boleto) {
        Boleto codigoBoleto = boletoRepository.findByCodigoDeBarras(boleto.getCodigo());

        if(codigoBoleto != null){
            throw new IllegalArgumentException("Esse código boleto já existe");
        }

        return boletoRepository.save(boleto);
    }

    public Conta findById(UUID id) {
        return contaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Conta não encontrada"));
    }

    // mudar status para true no frontend
    public void pagarBoleto(BoletoDTO boletoDTO) {
        Boleto boleto = boletoRepository.findByCodigoDeBarras(boletoDTO.getCodigo());
        Conta conta = findById(boletoDTO.getContaId());

        if (boleto == null) {
            throw new IllegalArgumentException("Boleto não encontrado.");
        }

        if (conta.getSaldo() < boleto.getValor()) {
            throw new IllegalArgumentException("Saldo insuficiente!");
        }

        conta.setSaldo(conta.getSaldo() - boletoDTO.getValor());

        Transacao transacao = new Transacao();
        transacao.setConta(conta);
        transacao.setTipoTransacao(3);
        transacao.setValor(boletoDTO.getValor());
        transacao.setDataTransacao(boletoDTO.getDataTransacao());
        transacao.setDescricao(boletoDTO.getBeneficiario());

        contaRepository.save(conta);
        boletoRepository.save(boleto);
        transacaoRepository.save(transacao);
    }


}
