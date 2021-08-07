package com.prova.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_cliente")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, length = 100)
	private String nome;
	@Column(nullable = false)
	private String cpf;
	
	@OneToMany(mappedBy = "cliente",  orphanRemoval = true, cascade = {CascadeType.REMOVE})
	private List<Endereco> endereco = new ArrayList<>();
	
	@OneToMany(mappedBy = "cliente",  orphanRemoval = true, cascade = {CascadeType.REMOVE})
	private List<Telefone> telefone = new ArrayList<>();
	
	@OneToMany(mappedBy = "cliente",  orphanRemoval = true, cascade = {CascadeType.REMOVE})
	private List<Email> email = new ArrayList<>();
	
	public Cliente() {}
	
	

	public Cliente(Long id, String nome, String cpf, List<Endereco> endereco, List<Telefone> telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
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



	public List<Endereco> getEndereco() {
		return endereco;
	}



	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}



	public List<Telefone> getTelefone() {
		return telefone;
	}



	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
	}



	
	public List<Email> getEmail() {
		return email;
	}



	public void setEmail(List<Email> email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", endereco=" + endereco + ", telefone="
				+ telefone + ", email=" + email + "]";
	}
	
	
	

}
