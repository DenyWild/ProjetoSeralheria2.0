package com.example.demo.model.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@Table(name = "pessoa",  uniqueConstraints= @UniqueConstraint(columnNames = "cpf"))
//@NoArgsConstructor
public class Pessoa {


	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id_pessoa;
	
	@Column(name = "nome", length = 70, nullable = false)
	@NotBlank(message = "O campo nome é obrigatório")
	private String nome;
	
	@Column(name = "telefone", length = 15, nullable = false)
	@NotBlank(message = "O campo telefone é obrigatório")
	private String telefone;
	
	@Column(name = "cpf", length = 11, nullable = false, unique = true)
	@NotBlank(message = "O campo cpf é obrigatório")
	private String Cpf;
	
	
	

	public Pessoa() {
		super();
		// TODO Auto-generated constructor stub
	}





	public Pessoa(@NotBlank(message = "O campo nome é obrigatório") String nome,
			@NotBlank(message = "O campo telefone é obrigatório") String telefone,
			@NotBlank(message = "O campo cpf é obrigatório") String cpf) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		Cpf = cpf;
	}





	public Integer getId_pessoa() {
		return id_pessoa;
	}





	public void setId_pessoa(Integer id_pessoa) {
		this.id_pessoa = id_pessoa;
	}





	public String getNome() {
		return nome;
	}





	public void setNome(String nome) {
		this.nome = nome;
	}





	public String getTelefone() {
		return telefone;
	}





	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}





	public String getCpf() {
		return Cpf;
	}





	public void setCpf(String cpf) {
		Cpf = cpf;
	}





	@Override
	public int hashCode() {
		return Objects.hash(Cpf, id_pessoa, nome, telefone);
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(Cpf, other.Cpf) && Objects.equals(id_pessoa, other.id_pessoa)
				&& Objects.equals(nome, other.nome) && Objects.equals(telefone, other.telefone);
	}
 
	
	
	
}