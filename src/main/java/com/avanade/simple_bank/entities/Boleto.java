package com.avanade.simple_bank.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

// boleto não vai ter mais relação com conta, dropar o banco de novo
@Entity
@Table(name = "TB_BOLETO")
public class Boleto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", updatable = false, nullable = false)
	private UUID id;

	// ver se isso vai dar problema no banco por ter sido só alterado aqui (unique)
	@Column(name = "CODIGO_DE_BARRAS", unique = true)
	private String codigo;

	@Column(name = "VALOR")
	private double valor;

	// dropar a tabela boleto
	@Column(name = "DATA_VENCIMENTO")
	private String dataVencimento;

	@Column(name = "STATUS_BOLETO")
	private boolean statusBoleto;

	@Column(name = "BENEFICIARIO")
	private String beneficiario;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public boolean isStatusBoleto() {
		return statusBoleto;
	}

	public void setStatusBoleto(boolean statusBoleto) {
		this.statusBoleto = statusBoleto;
	}

	public String getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(String beneficiario) {
		this.beneficiario = beneficiario;
	}
}
