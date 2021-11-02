package com.example.demo.model.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;



@Entity
@Table(name = "cliente")
public class Cliente {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
	private Long id;


@Column(name="nome", nullable = false)
	private String nome;

@Column(name="cpf", nullable = false)
 private String cpf;

@Column(name="telefone", nullable = false)
 private String telefone;

public Cliente() {
	
}



public Cliente(String nome, String cpf, String telefone) {
	super();
	this.nome = nome;
	this.cpf = cpf;
	this.telefone = telefone;
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
@Override
public int hashCode() {
	return Objects.hash(id);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Cliente other = (Cliente) obj;
	return Objects.equals(id, other.id);
}
}
