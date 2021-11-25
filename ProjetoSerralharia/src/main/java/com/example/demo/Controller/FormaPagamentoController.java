package com.example.demo.Controller;

import java.time.Instant;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Controller.exceptions.StandardError;
import com.example.demo.model.entities.FormaPagamento;
import com.example.demo.model.repositories.FormaPagamentoRepository;
import com.example.demo.services.FormaPagamentoService;
import com.example.demo.services.exceptions.EntityNotFoundException;

@RestController
@RequestMapping("/fpagamento")
public class FormaPagamentoController {
 
	@Autowired
 private FormaPagamentoService fpgService;

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT} )
	public  ResponseEntity<FormaPagamento> SalvarPagamentos(@Valid FormaPagamento formapagamento) {
		FormaPagamento fpg = fpgService.salvarPagamentos(formapagamento);
		return ResponseEntity.ok().body(fpg);
	}
    
	@GetMapping
	public Iterable<FormaPagamento> ConsultarFormasdePagamentos(){
		return fpgService.consultarFormasdePagamentos();
	}
	
	@GetMapping(path = "/{id_pagamento}")
	public ResponseEntity<FormaPagamento> ConsultarFormaPagamentoporId(@PathVariable Integer id_pagamento){
		FormaPagamento fpg = fpgService.findById(id_pagamento);
		return ResponseEntity.ok().body(fpg);
		
		
	}
	@DeleteMapping(path = "/{id_pagamento}")
	public void ExcluirFormaPagamentoporId(@PathVariable Integer id_pagamento) {
		fpgService.excluirFormaPagamentoporId(id_pagamento);
	}
}
