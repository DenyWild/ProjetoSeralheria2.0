package com.example.demo.Controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.entities.Cliente;
import com.example.demo.model.entities.Endereco;
import com.example.demo.model.entities.FormaPagamento;
import com.example.demo.model.repositories.EnderecoRepository;
import com.example.demo.services.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private EnderecoService enderecoService;

	  @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT} )
		public  ResponseEntity<Endereco> SalvarEnderecos(@Valid @RequestBody Endereco endereco) {
		  Endereco ende = enderecoService.salvarEnderecos(endereco);
			return ResponseEntity.ok().body(ende);
		}
	    
		@GetMapping
		public Iterable<Endereco> ConsultarEnderecos(){
			return enderecoService.mostrarEnderecos();
		}
		
		@GetMapping(path = "/{id_endereco}")
		public ResponseEntity<Endereco> ConsultarEnderecoporId(@PathVariable Integer id_endereco){
			Endereco ende = enderecoService.findById(id_endereco);
			return ResponseEntity.ok().body(ende);
			
			
		}
		@DeleteMapping(path = "/{id_endereco}")
		public void ExcluirEnderecoporId(@PathVariable Integer id_endereco) {
			enderecoService.deletarEnderecoPorId(id_endereco);
		}
}
