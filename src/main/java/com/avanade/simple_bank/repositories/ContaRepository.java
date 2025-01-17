package com.avanade.simple_bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.avanade.simple_bank.entities.Conta;

public interface ContaRepository extends JpaRepository<Conta, Integer> {
}