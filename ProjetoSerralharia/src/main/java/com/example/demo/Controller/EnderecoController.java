package com.example.demo.Controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.demo.model.repositories.EnderecoRepository;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoRepository;
	

	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public @ResponseBody Endereco salvarEndereco(@Valid Endereco endereco) {
	enderecoRepository.save(endereco);
	return endereco;
}
    /*@PutMapping
    public Endereco alteraarEndereco(@Valid Endereco endereco) {
    	enderecoRepository.save(endereco);
    		return endereco;
    }
     */
    @GetMapping
    public Iterable<Endereco> mostrarEndereco(){
    	return enderecoRepository.findAll();
    	
    }
    
    @GetMapping(path = "/{id_endereco}")
    public Optional<Endereco> consultarEnderecoPorId(@PathVariable Integer id_endereco){
    	return enderecoRepository.findById(id_endereco);
    	
    }
    @DeleteMapping(path = "/{id_endereco}")
    public void deletarEnderecoPorId(@PathVariable Integer id_endereco){
    	enderecoRepository.deleteById(id_endereco);
    	
    }
    
}
