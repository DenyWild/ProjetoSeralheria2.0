package com.example.demo.services;

import java.util.Optional;

import javax.validation.Valid;

import com.example.demo.model.entities.Orcamento;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

//METODO POST
public @ResponseBody Cliente salvarClientes (@Valid @RequestBody Cliente c) {
	c.getEnderecos().forEach( e -> e.setCliente(c));
	return clienteRepository.save(c);
	
}
/*
//METODO PUT
public Cliente alterarCliente (@PathVariable Integer id, Cliente c ){
	Cliente clienteSalva = findById(id);

	clienteSalva.getEnderecos().clear();

	clienteSalva.getEnderecos().addAll(c.getEnderecos());

	BeanUtils.copyProperties(c, clienteSalva, "id", "enderecos");

	return this.clienteRepository.save(clienteSalva);
}
*/

	public Cliente alterar (@PathVariable Integer id, @RequestBody Cliente cliente  ) {
		Optional<Cliente> procurado = this.clienteRepository.findById(id);
		Cliente result = null;


		result = procurado.get();
		result.getEnderecos().addAll(cliente.getEnderecos());
		BeanUtils.copyProperties(cliente, procurado, "id", "enderecos");
		return this.clienteRepository.save(result);

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


