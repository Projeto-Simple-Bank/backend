package com.avanade.simple_bank.repositories;

import com.avanade.simple_bank.entities.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface ContaRepository extends JpaRepository<Conta, UUID> {
    @Query("SELECT c FROM Conta c WHERE c.conta = :conta")
    Conta findByConta(@Param("conta") String conta);

    Optional<Conta> findByUsuarioId(UUID usuarioId);

}
