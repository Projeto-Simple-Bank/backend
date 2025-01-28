package com.avanade.simple_bank.repositories;

import com.avanade.simple_bank.entities.Boleto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoletoRepository extends JpaRepository<Boleto, Integer> {
    @Query("SELECT b FROM Boleto b WHERE b.codigo = :codigo")
    Boleto findByCodigoDeBarras(@Param("codigo") String codigo);
}
