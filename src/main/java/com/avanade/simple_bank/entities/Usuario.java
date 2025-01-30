package com.avanade.simple_bank.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", updatable = false, nullable = false)
	private UUID id;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "CPF")
	private String cpf;
	
	@Column(name = "RG")
	private String rg;
	
	@Column(name = "TELEFONE")
	private String telefone;
	
	@Column(name = "CEP")
	private String cep;
	
	@Column(name = "RUA")
	private String rua;
	
	@Column(name = "BAIRRO")
	private String bairro;
	
	@Column(name = "NUMERO")
	private int numero;
	
	@Column(name = "CIDADE")
	private String cidade;
	
	@Column(name = "ESTADO")
	private String estado;

	// quem ta sendo ligado pela a chave
	@OneToOne(mappedBy = "usuario")
	private Conta conta;

	@OneToOne(mappedBy = "usuario")
	private Administrador administrador; // ---

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
