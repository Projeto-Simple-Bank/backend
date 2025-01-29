package com.avanade.simple_bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avanade.simple_bank.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{}