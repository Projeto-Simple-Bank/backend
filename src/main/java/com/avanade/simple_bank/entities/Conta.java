package com.avanade.simple_bank.entities;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

import com.avanade.simple_bank.enumerations.Agencia;
import com.avanade.simple_bank.enumerations.TipoConta;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "TB_CONTA")
public class Conta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

//	@Enumerated(EnumType.STRING)  // Usando EnumType.STRING para armazenar como texto no banco
	@Column(name = "TIPO_CONTA")
	private int tipoConta; //vai virar enum

//	@Enumerated(EnumType.STRING)  // Usando EnumType.STRING para armazenar como texto no banco
	@Column(name = "AGENCIA")
	private int agencia; // vai virar enum

	@Column(name = "SALDO")
	private double saldo;

	@Column(name = "CONTA", unique = true)
	private String conta;

	// Construtor
	public Conta() {
		this.conta = gerarNumeroConta();
		this.senha = gerarSenha();
	}

	private String gerarNumeroConta() {
		Random random = new Random();
		// Gera um número aleatório de 7 dígitos com zeros à esquerda
		return String.format("%07d", random.nextInt(10000000));  // Ex: 0001234
	}

	@Column(name = "SENHA")
	private String senha;

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

	// quem tem a chave
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;

	@OneToOne(mappedBy = "conta")
	private Pix pix;

	@OneToOne(mappedBy = "conta")
	private Ted ted;

	@OneToOne(mappedBy = "conta")
	private Boleto boleto;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "conta")
	@JsonIgnore
	private List<Transacao> transacoes;

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "conta")
//	private List<Transacao> transacoes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

//	public List<Transacao> getTransacoes() {
//		return transacoes;
//	}
//
//	public void setTransacoes(List<Transacao> transacoes) {
//		this.transacoes = transacoes;
//	}
}