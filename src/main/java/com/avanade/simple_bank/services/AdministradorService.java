package com.avanade.simple_bank.services;

import com.avanade.simple_bank.entities.Administrador;
import com.avanade.simple_bank.repositories.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    public List<Administrador> listarAdmin() {
        return administradorRepository.findAll();
    }

    public Administrador criarAdmin(Administrador administrador) {
        return administradorRepository.save(administrador);
    }
}
