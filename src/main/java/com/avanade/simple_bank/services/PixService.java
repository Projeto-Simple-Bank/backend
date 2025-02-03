package com.avanade.simple_bank.services;

import com.avanade.simple_bank.entities.Conta;
import com.avanade.simple_bank.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avanade.simple_bank.repositories.PixRepository;
import com.avanade.simple_bank.entities.Pix;

import java.util.List;
import java.util.UUID;

@Service
public class PixService {

    @Autowired
    private PixRepository pixRepository;

    @Autowired
    private ContaRepository contaRepository;

    public Conta findById(UUID id) {
        return contaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Conta não encontrada"));
    }

    public Pix findChavePix(String chavePix) {
        return pixRepository.findByChavePix(chavePix);
    }

    public List<Pix> listarPix(Conta conta) {
        Conta findConta = findById(conta.getId());

        if (findConta != null) {
            return pixRepository.listarChavePixPorConta(findConta.getId());
        }

        throw new IllegalArgumentException("Conta não encontrada ou não há chave pix associadas.");
    }

    public Pix cadastrarPix(Pix pix) {
        Pix chavePix = pixRepository.findByChavePix(pix.getChavePix());

        if(chavePix != null){
            throw new IllegalArgumentException("Essa chave pix já existe.");
        }

        Conta conta = contaRepository.findById(pix.getConta().getId()).orElseThrow(() ->
                new IllegalArgumentException("Conta não encontrada"));

        pix.setConta(conta);
        conta.getPix().add(pix);
        contaRepository.save(conta);

        return pixRepository.save(pix);
    }
}
