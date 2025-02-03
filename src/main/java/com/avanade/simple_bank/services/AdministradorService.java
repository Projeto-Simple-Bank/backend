package com.avanade.simple_bank.services;

import com.avanade.simple_bank.entities.Administrador;
import com.avanade.simple_bank.entities.Conta;
import com.avanade.simple_bank.entities.Usuario;
import com.avanade.simple_bank.entities.Conta;
import com.avanade.simple_bank.repositories.AdministradorRepository;
import com.avanade.simple_bank.repositories.ContaRepository;
import com.avanade.simple_bank.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Administrador> listarAdmin() {
        return administradorRepository.findAll();
    }

    public Administrador criarAdmin(Administrador administrador) {
        return administradorRepository.save(administrador);
    }

    public Usuario editarUsuarioCliente(UUID clienteId, Usuario cliente) {
        Usuario contaExistente = usuarioRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));

        return usuarioRepository.save(contaExistente);
    }

    public Optional<Administrador> autenticar(String email, String senha) {
        Optional<Administrador> administrador = administradorRepository.findByEmail(email);

        if (administrador.isPresent() && administrador.get().getSenha().equals(senha)) {
            return administrador;
        }
        return Optional.empty();
    }
}
