package com.avanade.simple_bank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avanade.simple_bank.repositories.PixRepository;
import com.avanade.simple_bank.entities.Pix;

import java.util.List;

@Service
public class PixService {

    @Autowired
    private PixRepository pixRepository;

    public Pix cadastrarPix(Pix pix) {
        return pixRepository.save(pix);
    }
}
