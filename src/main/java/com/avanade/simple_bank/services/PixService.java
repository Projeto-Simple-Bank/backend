package com.avanade.simple_bank.services;

import com.avanade.simple_bank.entities.Conta;
import com.avanade.simple_bank.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avanade.simple_bank.repositories.PixRepository;
import com.avanade.simple_bank.entities.Pix;

import java.util.List;

@Service
public class PixService {

    @Autowired
    private PixRepository pixRepository;

    @Autowired
    private ContaRepository contaRepository;

    public List<Pix> listarPix() {
        return pixRepository.findAll();
    }

    public Pix listarChavePix(String chavePix) {
        return pixRepository.findByChavePix(chavePix);
    }

    // se o cadastro do pix continuar dando errado, a gente coloca a chavePix como Primary
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
