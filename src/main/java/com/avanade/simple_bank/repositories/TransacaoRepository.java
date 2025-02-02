package com.avanade.simple_bank.repositories;

import com.avanade.simple_bank.entities.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface TransacaoRepository extends JpaRepository<Transacao, UUID> {
    @Query("SELECT t FROM Transacao t WHERE t.conta.id = :contaId")
    List<Transacao> listarTransacaoPorConta(@Param("contaId") UUID contaId);
}
