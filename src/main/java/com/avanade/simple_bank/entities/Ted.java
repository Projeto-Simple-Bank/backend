package com.avanade.simple_bank.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_TED")
public class Ted {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "TARIFA")
	private double tarifa;
	
	@Column(name = "DESCRICAO")
	private String descricao;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_CONTA")
	private Conta conta;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public double getTarifa() {
		return tarifa;
	}

	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
