package com.avanade.simple_bank.entities;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "TB_TRANSACAO")
public class Transacao {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", updatable = false, nullable = false)
	private UUID id;

	// tem que arrumar os enums
//	@Enumerated(EnumType.ORDINAL)
	@Column(name = "TIPO_TRANSACAO")
	private int tipoTransacao;

	// nao sei se está funcionando corretamente (é um teste)
//	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "DATA_TRANSACAO") // concertar
//	private LocalDate dataTransacao;
	private String dataTransacao;

//	@JsonFormat(pattern = "HH:mm:ss")
//	@Transient // Não precisa ser persistido no banco, apenas para a resposta
//	private LocalTime hora;

	@Column(name = "VALOR")
	private double valor;

	@Column(name = "DESCRICAO")
	private String descricao;

	// será que devo colocar json ignore na requisicao?
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_CONTA")
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

	public int getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(int tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}


	public String getDataTransacao() {
		return dataTransacao;
	}

	public void setDataTransacao(String dataTransacao) {
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
