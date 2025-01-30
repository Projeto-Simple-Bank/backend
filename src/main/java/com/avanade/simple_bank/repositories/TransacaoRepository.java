package com.avanade.simple_bank.repositories;

import com.avanade.simple_bank.entities.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransacaoRepository extends JpaRepository<Transacao, UUID> {
}
