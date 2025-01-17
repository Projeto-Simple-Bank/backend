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
@Table(name = "TB_BOLETO")
public class Boleto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "CODIGO_DE_BARRAS")
	private int codigo;
	
	@Column(name = "BENEFICIARIO")
	private String beneficiario;

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

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(String beneficiario) {
		this.beneficiario = beneficiario;
	}
}
