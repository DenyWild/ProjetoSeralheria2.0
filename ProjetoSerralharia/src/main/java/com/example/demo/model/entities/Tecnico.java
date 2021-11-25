package com.example.demo.model.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table
public class Tecnico extends Pessoa {



	public Tecnico(@NotNull int codcesso) {
		super();
		this.codcesso = codcesso;
	}


	public Tecnico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tecnico(@NotBlank(message = "O campo nome é obrigatório") String nome,
			@NotBlank(message = "O campo telefone é obrigatório") String telefone,
			@NotBlank(message = "O campo cpf é obrigatório") String cpf) {
		super(nome, telefone, cpf);
		// TODO Auto-generated constructor stub
	}


	@Column
	@NotNull
	private int codcesso = 3030;
	

	public int getCodcesso() {
		return codcesso;
	}

	public void setCodcesso(int codcesso) {
		this.codcesso = codcesso;
	}


	public String toString() {
		return"Alunos: \n"+getNome()+"\nCPF: \n"+getCpf();
	}


	
}