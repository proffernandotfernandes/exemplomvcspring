package br.senacedu.exemplomvc.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCliente;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable = false, unique = true)
	private String CPF;
	
	public Cliente() {
		
	}
	
	

	public Cliente(String nome, String cpf) {
		super();
		this.nome = nome;
		CPF = cpf;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}
	
	@Override
	public String toString() {
		return "Cliente{" +
				"id=" + idCliente +
				", nome='" + nome + "\'" +
				", cpf='" + CPF + "\'" + 
				"}";
		
	}
	
	
}
