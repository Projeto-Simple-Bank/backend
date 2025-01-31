package com.avanade.simple_bank.entities;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "TB_CONTA")
public class Conta {
	// colocar instituição aqui
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", updatable = false, nullable = false)
	private UUID id;

	@Column(name = "TIPO_CONTA")
	private int tipoConta; //vai virar enum

	@Column(name = "AGENCIA")
	private int agencia;

	@Column(name = "SALDO")
	private double saldo;

	@Column(name = "CONTA")
	private int conta;

	@Column(name = "SENHA")
	private String senha;

	// quem tem a chave
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "conta")
	private List<Pix> pix;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "conta")
	private List<Transacao> transacoes;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(int tipoConta) {
		this.tipoConta = tipoConta;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia() {
		this.agencia = 1001;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}

	public List<Pix> getPix() {
		return pix;
	}

	public void setPix(List<Pix> pix) {
		this.pix = pix;
	}
}
