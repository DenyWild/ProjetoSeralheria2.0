package com.example.demo.Controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.entities.FormaPagamento;
import com.example.demo.model.repositories.FormaPagamentoRepository;

@RestController
@RequestMapping("/fpagamento")
public class FormaPagamentoController {
 
 
 
 @Autowired
 private FormaPagamentoRepository fPagamentoRepository;
	
   // @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT} )
 @PostMapping
	public  @ResponseBody FormaPagamento SalvarPagamentos(@Valid 
			@RequestParam int tipopagamento ,
			@RequestParam double especie,
			@RequestParam double credito,
			@RequestParam double debito, 
			@RequestParam int vezes) {
    	FormaPagamento fpg = new FormaPagamento(tipopagamento, especie, credito, debito, vezes);
    	
		 fPagamentoRepository.save(fpg);
		 return fpg;
	}
    
	@GetMapping
	public Iterable<FormaPagamento> ConsultarFormasdePagamentos(){
		return fPagamentoRepository.findAll();
	}
	
	@GetMapping(path = "/{id_pedido}")
	public Optional<FormaPagamento> ConsultarFormaPagamentoporId(@PathVariable Integer id_pagamento){
		return fPagamentoRepository.findById(id_pagamento);
		
	}
	@DeleteMapping(path = "/{id_pedido}")
	public void ExcluirFormaPagamentoporId(@PathVariable Integer id_pagamento) {
		fPagamentoRepository.deleteById(id_pagamento);
	}
}
