package com.avanade.simple_bank.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CONTA")
public class Conta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;
	
	@Column(name = "TIPO_CONTA")
	private int tipoConta; //vai virar enum
	
	@Column(name = "AGENCIA")
	private int agencia; // vai virar enum
	
	@Column(name = "SALDO")
	private double saldo;
	
	@Column(name = "CONTA")
	private int conta;
	
	@Column(name = "SENHA")
	private String senha;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "conta")
	private List<Transacao> transacoes;
}
