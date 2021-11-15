package com.example.demo.model.entities;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name= "orcamento")
public class Orcamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private Integer id_orcamento;
	
	@Column(name= "precoAluminio")
	@NotBlank(message = "Cmapo preçoAluminio é obrigatório")
	private double precoAluminio;
	
	@Column(name= "altura")
	@NotBlank(message = "Campo altura é obrigatório")
	private double altura;
	
	@Column(name= "largura")
	@NotBlank(message = "Campo largura é obrigatório")
	private double largura;
	
	@Column(name= "metrosqd")
	@NotBlank(message = "Campo metrosqd é obrigatório")
	private double metrosqd;
	
	@Column(name= "tipomaterial")
	@NotBlank(message = "Campo tipomaterial é obrigatório")
	private int tipomaterial;
	
	@Column(name= "total")
	@NotBlank(message = "Campo total é obrigatório")
	private double total;
	
	
	public Orcamento() {
		super();
	}
	public Orcamento(double precoAluminio, double altura, double largura, double metrosqd, int tipomaterial, double total) {
		super();
		this.precoAluminio = precoAluminio;
		this.altura = altura;
		this.largura = largura;
		this.metrosqd = metrosqd;
		this.tipomaterial = tipomaterial;
		this.total = total;
	}
	public double getPrecoAluminio() {
		return precoAluminio;
	}
	public void setPrecoAluminio(double $aluminio) {
		this.precoAluminio = $aluminio;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getLargura() {
		return largura;
	}
	public void setLargura(double largura) {
		this.largura = largura;
	}
	public double getMetrosqd() {
		return getAltura() * getLargura() ;
	}
	public void setMetrosqd(double metrosqd) {
		this.metrosqd = metrosqd;
	}
	public int getTipomaterial() {
		return tipomaterial;
	}
	public void setTipomaterial(int escprodut) {
		
		switch (escprodut) {
		case 1:
			int cor1=35;
			setTotal((getMetrosqd() * cor1)*5);
			this.tipomaterial = escprodut;
			break;
		case 2:
			int cor2=40;
			setTotal((getMetrosqd() * cor2)*5);
			this.tipomaterial = escprodut;
			break;
		}
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return"[ "+getAltura()+" "+getLargura()+" "+getMetrosqd()+" "+getTotal()+" ]";
	}
	public int getId_orcamento() {
		return id_orcamento;
	}
	public void setId_orcamento(int id_orcamento) {
		this.id_orcamento = id_orcamento;
	}
	public void setId_orcamento(Integer id_orcamento) {
		this.id_orcamento = id_orcamento;
	}
	
	
}
