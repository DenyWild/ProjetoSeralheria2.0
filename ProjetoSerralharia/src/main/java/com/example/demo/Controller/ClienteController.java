package com.example.demo.Controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.entities.Cliente;
import com.example.demo.services.ClienteService;


@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	

@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT} )
public  ResponseEntity<Cliente> SalvarClientes(@Valid Cliente cliente) {
	Cliente cli = clienteService.salvarClientes(cliente) ;
	return ResponseEntity.ok().body(cli);
}

@GetMapping
public Iterable<Cliente> ConsultarClientes(){
	return clienteService.consultarClientes();
}

@GetMapping(path = "/{id}")
public ResponseEntity<Cliente> ConsultarClienteporId(@PathVariable Integer id){
	Cliente cli = clienteService.findById(id);
	return ResponseEntity.ok().body(cli);
	
	
}
@DeleteMapping(path = "/{id}")
public void ExcluirClienteporId(@PathVariable Integer id) {
	clienteService.excluirClientePorId(id);
}
	

	@GetMapping(path = "/pagina/{numeroPagina}/{qtdPagina}")
	public Iterable<Cliente> obterClientePorPagina(@PathVariable int numeroPagina, 
			@PathVariable int qtdPagina){
		return clienteService.obterClientePorPagina(numeroPagina, qtdPagina);
	}


@GetMapping(path = "/nome/{parteNome}")
public Iterable<Cliente> ObterClientesPorNome(@PathVariable String parteNome){
	return clienteService.ObterClientesPorNome(parteNome);
	
}

@GetMapping(path = "/cpf/{cpf}")
public Optional<Cliente> ObterClientesPorCpf(@PathVariable String cpf){
	return clienteService.ObterClientesPorCpf(cpf);
	
}

}
