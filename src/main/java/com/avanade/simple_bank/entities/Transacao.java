package com.avanade.simple_bank.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import com.avanade.simple_bank.enumerations.TipoTransacao;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

// adiciona a descricao aqui e remover do pix e ted
@Entity
@Table(name = "TB_TRANSACAO")
public class Transacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	// tem que arrumar os enums
	@Column(name = "TIPO_TRANSACAO")
	@Enumerated(EnumType.ORDINAL)
	private TipoTransacao tipoTransacao;
	
	@Column(name = "TIPO_OPERACAO")
	private int tipoOperacao; // vai virar enum

	// nao sei se está funcionando corretamente (é um teste)
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "DATA_TRANSACAO")
	@CreationTimestamp
	private Date dataTransacao;
	
	@Column(name = "VALOR")
	private double valor;

	@Column(name = "DESCRICAO")
	private String descricao;

	@ManyToOne(fetch = FetchType.EAGER)
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

	public TipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(TipoTransacao tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}

	public int getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(int tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	public Date getDataTransacao() {
		return dataTransacao;
	}

	public void setDataTransacao(Date dataTransacao) {
		this.dataTransacao = dataTransacao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
