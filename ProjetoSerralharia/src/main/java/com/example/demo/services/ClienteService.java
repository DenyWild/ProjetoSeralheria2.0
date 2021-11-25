package com.example.demo.services;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.entities.Cliente;
import com.example.demo.model.repositories.ClienteRepository;
import com.example.demo.services.exceptions.EntityNotFoundException;

@Service
public class ClienteService {

	
	@Autowired
	private ClienteRepository clienteRepository;
	
	//METODO GET FIND BY ID
public Cliente findById( Integer id) {
		
		return clienteRepository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("Id not found "+id));
	}

//METODO POST E PUT NA MESMA FUNÇÃO
public @ResponseBody Cliente salvarClientes (@Valid Cliente cliente) {
	clienteRepository.save(cliente);
	return cliente;
	
}
//METODO GET POR PAGINA APENAS PARA CLASSE CLIENTE
public Iterable<Cliente> obterClientePorPagina(@PathVariable int numeroPagina, 
		@PathVariable int qtdPagina){
	if(qtdPagina >= 5) qtdPagina = 5;
	Pageable page = PageRequest.of(numeroPagina, qtdPagina);
	return clienteRepository.findAll(page);
}

//METODO GET FIND ALL
public Iterable<Cliente> consultarClientes(){
return clienteRepository.findAll();
}


//METODO GET FIND BY NOME APENAS DA CLASSE CLIENTE
public Iterable<Cliente> ObterClientesPorNome(@PathVariable String parteNome){
return clienteRepository.findByNomeContainingIgnoreCase(parteNome);

}
//METODO GET FIND BY CPF APENAS DA CLASSE CLIENTE
public Optional<Cliente> ObterClientesPorCpf(@PathVariable String cpf){
return clienteRepository.findByCpf(cpf);

}
//METODO DELETE BY ID
public void excluirClientePorId(@PathVariable Integer id) {
clienteRepository.deleteById(id);

}

}


