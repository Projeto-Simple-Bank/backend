package com.avanade.simple_bank.entities;

import java.security.SecureRandom;
import java.util.List;
import java.util.UUID;
import java.util.Random;

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
//	@Enumerated(EnumType.STRING)  // Usando EnumType.STRING para armazenar como texto no banco
	private int tipoConta; //vai virar enum

	@Column(name = "ATIVA")
	private int ativa;


	@Column(name = "AGENCIA") // não deve ser not null no banco
	private int agencia;

	@Column(name = "SALDO")
	private double saldo;

	@Column(name = "CONTA", unique = true)
	private String conta;

	@Column(name = "SENHA")
	private String senha;

	// quem tem a chave
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "conta")
	private List<Pix> pix;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "conta")
	@JsonIgnore
	private List<Transacao> transacoes;

	private String gerarNumeroConta() {
		Random random = new Random();
		// Gera um número aleatório de 7 dígitos com zeros à esquerda
		return String.format("%07d", random.nextInt(10000000));  // Ex: 0001234
	}
	private String gerarSenha() {
		SecureRandom random = new SecureRandom();
		// Gera uma senha aleatória de 12 caracteres (usando letras e números)
		String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder senha = new StringBuilder();
		for (int i = 0; i < 12; i++) {
			int indice = random.nextInt(caracteres.length());
			senha.append(caracteres.charAt(indice));
		}
		return senha.toString();
	}

	// Construtor
	public Conta() {
		this.setConta(gerarNumeroConta());
		this.setSenha(gerarSenha());
		this.setAgencia(1001);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public int getAtiva() {
		return ativa;
	}

	public void setAtiva(int ativa) {
		this.ativa = ativa;
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

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
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
