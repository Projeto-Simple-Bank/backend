package com.avanade.simple_bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avanade.simple_bank.entities.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

    @Query(value = "SELECT * FROM TB_USUARIO WHERE ID = :valorid", nativeQuery = true)
    List<Usuario> buscarUsuariosByID(@Param("valorid") String id);
}