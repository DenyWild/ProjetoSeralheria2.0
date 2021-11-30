package com.example.demo.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.entities.FormaPagamento;
import com.example.demo.model.repositories.FormaPagamentoRepository;
import com.example.demo.services.exceptions.EntityNotFoundException;

@Service
public class FormaPagamentoService {

	 
	 @Autowired
	 private FormaPagamentoRepository fPagamentoRepository;
		
	//METODO GET FIND BY ID
	public FormaPagamento findById( Integer id) {
		
		return fPagamentoRepository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("Id not found "+id));
	}
	//METODO POST E PUT NA MESMA FUNÇÃO
    public  @ResponseBody FormaPagamento salvarPagamentos(@Valid FormaPagamento formapagamento) throws IllegalAccessException {
    	FormaPagamento result = null;
    	FormaPagamento atual = fPagamentoRepository.save(formapagamento);
    	result = atual;
    	result.setFormaPag(formapagamento.getFormaPag());
		 return this.fPagamentoRepository.save(result);
		 }
    //METODO GET FIND ALL
    public Iterable<FormaPagamento> consultarFormasdePagamentos(){
		return fPagamentoRepository.findAll();
	}
    //METODO DELETE BY ID
    public void excluirFormaPagamentoporId(@PathVariable Integer id_pagamento) {
		fPagamentoRepository.deleteById(id_pagamento);
    }
}
