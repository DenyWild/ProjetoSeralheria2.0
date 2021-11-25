package com.example.demo.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.entities.Endereco;
import com.example.demo.model.repositories.EnderecoRepository;
import com.example.demo.services.exceptions.EntityNotFoundException;

@Service
public class EnderecoService {

	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	//METODO POST E PUT NO MESMA FUNÇÃO
	public @ResponseBody Endereco salvarEnderecos(@Valid Endereco endereco) {
		enderecoRepository.save(endereco);
		return endereco;
	}
	//METODO GET FIND ALL
	    public Iterable<Endereco> mostrarEnderecos(){
	    	return enderecoRepository.findAll();
	    	
	    }
	    
	//METODO GET FIND BY ID
	   public Endereco findById( Integer id_endereco) {
			
			return enderecoRepository.findById(id_endereco).orElseThrow(
					() -> new EntityNotFoundException("Id not found "+id_endereco));
		}
	    
	  //METODO DELETE BY ID
	    public void deletarEnderecoPorId(@PathVariable Integer id_endereco){
	    	enderecoRepository.deleteById(id_endereco);
	    	
	    }
	    
	}


