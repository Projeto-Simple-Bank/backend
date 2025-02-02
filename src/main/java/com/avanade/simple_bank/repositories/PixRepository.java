package com.avanade.simple_bank.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.avanade.simple_bank.entities.Pix;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PixRepository extends JpaRepository<Pix, UUID> {
    @Query("SELECT p FROM Pix p WHERE p.chavePix = :chavePix")
    Pix findByChavePix(@Param("chavePix") String chavePix);

    @Query("SELECT p FROM Pix p WHERE p.conta.id = :contaId")
    List<Pix> listarChavePixPorConta(@Param("contaId") UUID contaId);
}
