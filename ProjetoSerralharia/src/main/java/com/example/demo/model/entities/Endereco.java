package com.example.demo.model.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_endereco")
	private Integer id_endereco;
	
	@Column(name="rua",length = 50, nullable = false)
	@NotBlank(message = "Campo rua é obrigatório")
	private String rua;
	
	@Column(name="bairro",length = 50, nullable = false)
	@NotBlank(message = "Campo bairro é obrigatório")
	private String bairro;
	
	@Column(name="estado", length = 30, nullable = false)
	@NotBlank(message = "Campo estado é obrigatório")
	private String estado;
	
	@Column(name="numero", nullable = false)
	@NotNull(message = "Campo numero é obrigatório")
	@Size(min = 1, max = 4, message = "O campo numero deve ter entre 1 e 4 caracteres")
	private int numero;
	
	@Column(name="cidade",length = 35, nullable = false)
	@NotBlank(message = "Campo cidade é obrigatório")
	private String cidade;
	
	@Column(name="cep",length = 8, nullable = false)
	@NotBlank(message = "Campo cep é obrigatório")
	@Size(min = 8, max = 8, message = "O campo cep tem que ter 8 caracteres")
	private String cep;
	
	@Column(name="ponto_referencia",  nullable = false)
	@NotBlank(message = "Campo ponto de referencia é obrigatório")
	private String pontRef;


	public Endereco() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Endereco(@NotBlank(message = "Campo rua é obrigatório") String rua,
			@NotBlank(message = "Campo bairro é obrigatório") String bairro,
			@NotBlank(message = "Campo estado é obrigatório") String estado,
			@NotNull(message = "Campo numero é obrigatório") @Size(min = 1, max = 4, message = "O campo numero deve ter entre 1 e 4 caracteres") int numero,
			@NotBlank(message = "Campo cidade é obrigatório") String cidade,
			@NotBlank(message = "Campo cep é obrigatório") @Size(min = 8, max = 8, message = "O campo cep tem que ter 8 caracteres") String cep,
			@NotBlank(message = "Campo ponto de referencia é obrigatório") String pontRef) {
		super();
		this.rua = rua;
		this.bairro = bairro;
		this.estado = estado;
		this.numero = numero;
		this.cidade = cidade;
		this.cep = cep;
		this.pontRef = pontRef;
	}






	public Integer getId_endereco() {
		return id_endereco;
	}



	public void setId_endereco(Integer id_endereco) {
		this.id_endereco = id_endereco;
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



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
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



	public String getCep() {
		return cep;
	}



	public void setCep(String cep) {
		this.cep = cep;
	}



	public String getPontRef() {
		return pontRef;
	}



	public void setPontRef(String pontRef) {
		this.pontRef = pontRef;
	}



	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, cidade, estado, id_endereco, numero, pontRef, rua);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
				&& Objects.equals(cidade, other.cidade) && Objects.equals(estado, other.estado)
				&& Objects.equals(id_endereco, other.id_endereco) && Objects.equals(numero, other.numero)
				&& Objects.equals(pontRef, other.pontRef) && Objects.equals(rua, other.rua);
	}
	
	
	

}
