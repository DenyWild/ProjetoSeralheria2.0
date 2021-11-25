package com.example.demo.Controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
		public  ResponseEntity<Endereco> SalvarEnderecos(@Valid Endereco endereco) {
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
