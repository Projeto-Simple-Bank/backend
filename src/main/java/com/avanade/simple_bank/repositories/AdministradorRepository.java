package com.avanade.simple_bank.repositories;

import com.avanade.simple_bank.entities.Administrador;
import com.avanade.simple_bank.entities.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
import java.util.Optional;

public interface AdministradorRepository extends JpaRepository<Administrador, UUID> {
 Optional<Administrador> findByEmail(String email);
}
