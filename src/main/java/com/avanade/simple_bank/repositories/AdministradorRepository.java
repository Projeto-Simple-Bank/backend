package com.avanade.simple_bank.repositories;

import com.avanade.simple_bank.entities.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdministradorRepository extends JpaRepository<Administrador, UUID> {
}
