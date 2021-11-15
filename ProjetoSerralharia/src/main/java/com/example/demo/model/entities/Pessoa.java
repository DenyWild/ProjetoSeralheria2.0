package com.example.demo.model.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pessoa {

	private int id_pessoa;
	private String nome;
	private String telefone;
	private String Cpf;
	private Endereco endereco;
	
	
	public Pessoa( String nome, String telefone, String cpf, Endereco endereco) {
		this.telefone = telefone;
		Cpf = cpf;
	}

	
	
}