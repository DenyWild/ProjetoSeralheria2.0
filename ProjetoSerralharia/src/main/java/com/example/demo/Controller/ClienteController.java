package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.entities.Cliente;
import com.example.demo.model.repositories.ClienteRepository;




@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
//	@PostMapping
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public @ResponseBody Cliente salvarCliente (@Valid Cliente cliente) {
	clienteRepository.save(cliente);
	return cliente;
}
	
	@GetMapping(path = "/pagina/{numeroPagina}/{qtdPagina}")
	public Iterable<Cliente> obterClientePorPagina(@PathVariable int numeroPagina, 
			@PathVariable int qtdPagina){
		if(qtdPagina >= 5) qtdPagina = 5;
		Pageable page = PageRequest.of(numeroPagina, qtdPagina);
		return clienteRepository.findAll(page);
	}
	
@GetMapping
public Iterable<Cliente> consultarClientes(){
	return clienteRepository.findAll();
	
}

@GetMapping(path = "/nome/{parteNome}")
public Iterable<Cliente> ObterClientesPorNome(@PathVariable String parteNome){
	return clienteRepository.findByNomeContainingIgnoreCase(parteNome);
	
}

@GetMapping(path = "/{id}")
public Optional<Cliente> obterClientePorId(@PathVariable Integer id){
	return clienteRepository.findById(id);
}

//@PutMapping
//public  Cliente alterarCliente (@Valid Cliente cliente) {
//clienteRepository.save(cliente);
//return cliente;
//}

@DeleteMapping(path = "/{id}")
public void excluirClientePorId(@PathVariable Integer id) {
	clienteRepository.deleteById(id);
}
	
}
