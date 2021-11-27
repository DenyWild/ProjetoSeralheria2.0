package com.example.demo.model.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table
public class FormaPagamento {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id_pagamento;
	
	@Column
	@NotBlank(message = "Campo tipopagamento é obrigatório")
    private String tipopagamento;

	
	public FormaPagamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FormaPagamento(@NotBlank(message = "Campo tipopagamento é obrigatório") String tipopagamento) {
		super();
		this.tipopagamento = tipopagamento;
		getTipopagamento();
	}

	public Integer getId_pagamento() {
		return id_pagamento;
	}

	public void setId_pagamento(Integer id_pagamento) {
		this.id_pagamento = id_pagamento;
	}

	public String getTipopagamento() {
		
		if(tipopagamento.equalsIgnoreCase("1")) {
			tipopagamento = ("Credito");
		}
		if(tipopagamento.equalsIgnoreCase("2")) {
			tipopagamento = ("Debito");
		}
		if(tipopagamento.equalsIgnoreCase("3")) {
			tipopagamento = ("Especie");
		}
		
		return tipopagamento;
	}

	public void setTipopagamento(String tipopagamento) {
		this.tipopagamento = tipopagamento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_pagamento, tipopagamento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FormaPagamento other = (FormaPagamento) obj;
		return id_pagamento == other.id_pagamento && Objects.equals(tipopagamento, other.tipopagamento);
	}
	
	


}