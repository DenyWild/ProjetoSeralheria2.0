package com.example.demo.model.entities;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "orcamento")
public class Orcamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id_orcamento")
	private Integer id_orcamento;
	
	@Column(name= "precoAluminio", nullable = false)
    @NotNull(message = "Campo precoAluminio é obrigatório")
	private double precoAluminio;
	
	@Column(name= "altura", nullable = false)
	@NotNull(message = "Campo altura é obrigatório")
	private double altura;
	
	@Column(name= "largura", nullable = false)
	@NotNull(message = "Campo largura é obrigatório")
	private double largura;
	
	@Column(name= "metrosqd", nullable = false)
	@NotNull(message = "Campo metrosqd é obrigatório")
	private double metrosqd;
	
	@Column(name= "tipomaterial", nullable = false)
	@NotNull(message = "Campo tipomaterial é obrigatório")
	private int tipomaterial;
	
	@Column(name= "total", nullable = false)
	@NotNull(message = "Campo total é obrigatório")
	private double total;
	
	
	public Orcamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orcamento(@NotNull(message = "Campo precoAluminio é obrigatório") double precoAluminio,
			@NotNull(message = "Campo altura é obrigatório") double altura,
			@NotNull(message = "Campo largura é obrigatório") double largura,
			@NotNull(message = "Campo metrosqd é obrigatório") double metrosqd,
			@NotNull(message = "Campo tipomaterial é obrigatório") int tipomaterial,
			@NotNull(message = "Campo total é obrigatório") double total) {
		super();
		this.precoAluminio = precoAluminio;
		this.altura = altura;
		this.largura = largura;
		this.metrosqd = metrosqd;
		this.tipomaterial = tipomaterial;
		this.total = total;
	}

	public Integer getId_orcamento() {
		return id_orcamento;
	}

	public void setId_orcamento(Integer id_orcamento) {
		this.id_orcamento = id_orcamento;
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
	public void setTipomaterial(int tipomaterial) {
		
		switch (tipomaterial) {
		case 1:
			int cor1=35;
			setTotal((getMetrosqd() * cor1)*5);
			this.tipomaterial = tipomaterial;
			break;
		case 2:
			int cor2=40;
			setTotal((getMetrosqd() * cor2)*5);
			this.tipomaterial = tipomaterial;
			break;
		}
	}
	public double getTotal(int tipomaterial) {

		switch (tipomaterial) {
		case 1:
			int cor1=35;
			total=((getMetrosqd() * cor1)*5);
			this.tipomaterial = tipomaterial;
			break;
		case 2:
			int cor2=40;
			total=((getMetrosqd() * cor2)*5);
			this.tipomaterial = tipomaterial;
			break;
		}
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return"[ "+getAltura()+" "+getLargura()+" "+getMetrosqd()+" "+getTotal(tipomaterial)+" ]";
	}
	
}
