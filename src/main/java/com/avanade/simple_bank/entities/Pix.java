package com.avanade.simple_bank.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "TB_PIX")
public class Pix {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", updatable = false, nullable = false)
	private UUID id;
	
	@Column(name = "CHAVE_PIX")
	private String chavePix;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_CONTA") // unique = true
	private Conta conta;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public String getChavePix() {
		return chavePix;
	}

	public void setChavePix(String chavePix) {
		this.chavePix = chavePix;
	}
}
