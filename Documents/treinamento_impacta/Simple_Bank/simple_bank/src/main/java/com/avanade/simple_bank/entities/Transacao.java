package com.avanade.simple_bank.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "TB_TRANSACAO")
public class Transacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CONTA")
	private Conta conta;
	
	@Column(name = "TIPO_TRASACAO")
	private int tipoTransacao; // vai virar enum
	
	@Column(name = "TIPO_OPERACAO")
	private int tipoOperacao; // vai virar enum

	@Column(name = "DATA_TRASACAO")
	private Date dataTransacao;
	
	@Column(name = "VALOR")
	private double valor;
	
}
