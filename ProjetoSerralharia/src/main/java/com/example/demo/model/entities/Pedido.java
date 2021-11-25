package com.example.demo.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
private Integer id_pedido;
	
	@Column
	@NotBlank(message = "Campo tipopedido é obrigatorio")
	private String tipopedido;
	
	
	
	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Pedido(@NotBlank(message = "Campo tipopedido é obrigatorio") String tipopedido) {
		super();
	this.tipopedido = tipopedido;
    getTipopedido();

	}
	

	
	public Integer getId_pedido() {
		return id_pedido;
	}


	public void setId_pedido(Integer id_pedido) {
		this.id_pedido = id_pedido;
	}


	public String getTipopedido() {

		if(tipopedido.equalsIgnoreCase("1")) {
			tipopedido=("JANELA");
		
		}
		if(tipopedido.equalsIgnoreCase("2")) {
			tipopedido=("PORTA");
			
		}
		if(tipopedido.equalsIgnoreCase("3")) {
			tipopedido=("PORTAO");
		
				}
		if(tipopedido.equalsIgnoreCase("4")) {
		    tipopedido=("TOLDO");
		}
		//ELSE COM MAU FUNCIONAMENTO
		/*
		   else {
		    	tipopedido = ("PEDIDO INVALIDO");
		    }*/
			
//
		return tipopedido;
	}

	public void setTipopedido(String tipopedido) {
		
		this.tipopedido = tipopedido;
		
				
	}

	@Override
	public String toString() {
		return ""+this.tipopedido ;
	}
}
