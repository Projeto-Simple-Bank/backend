package com.avanade.simple_bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.avanade.simple_bank.entities.Pix;

public interface PixRepository extends JpaRepository<Pix, String> { }
