package com.example.demo.Controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.entities.Cliente;
import com.example.demo.model.entities.Pessoa;
import com.example.demo.model.repositories.PessoaRepository;
 @RestController
 @RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public @ResponseBody Pessoa salvarPessoa (@Valid Pessoa pessoa) {
		pessoaRepository.save(pessoa);
	return pessoa;
}


@GetMapping
public Iterable<Pessoa> consultarPessoas(){
	return pessoaRepository.findAll();
}



@GetMapping(path = "/{id_pessoa}")
public Optional<Pessoa> obterPessoaPorId(@PathVariable Integer id_pessoa){
	return pessoaRepository.findById(id_pessoa);
}


@DeleteMapping(path = "/{id_pessoa}")
public void excluirPessoaPorId(@PathVariable Integer id_pessoa) {
	pessoaRepository.deleteById(id_pessoa);

}
	
}
