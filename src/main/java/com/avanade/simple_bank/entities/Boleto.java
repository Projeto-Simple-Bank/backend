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

import java.util.UUID;

@Entity
@Table(name = "TB_BOLETO")
public class Boleto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", updatable = false, nullable = false)
	private UUID id;
	
	@Column(name = "CODIGO_DE_BARRAS")
	private String codigo;

	@Column(name = "VALOR")
	private double valor;

	@Column(name = "STATUS_BOLETO")
	private boolean statusBoleto;

	@Column(name = "BENEFICIARIO")
	private String beneficiario;

	// colocar data, hora, descricao e vencimento

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_CONTA")
	private Conta conta;

	public Boleto () {}

	public Boleto(UUID id, String codigo, double valor, boolean statusBoleto, String beneficiario, Conta conta) {
		this.setId(id);
		this.setCodigo(codigo);
		this.setValor(valor);
		this.setStatusBoleto(statusBoleto);
		this.setBeneficiario(beneficiario);
		this.setConta(conta);
	}

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

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
}
