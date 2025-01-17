package com.avanade.simple_bank.repositories;

import com.avanade.simple_bank.entities.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {
}
