package com.avanade.simple_bank.repositories;

import com.avanade.simple_bank.entities.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContaRepository extends JpaRepository<Conta, UUID> { }
