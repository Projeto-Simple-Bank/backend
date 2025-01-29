package com.avanade.simple_bank.repositories;

import com.avanade.simple_bank.entities.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorRepository extends JpaRepository<Administrador, String> {
}
