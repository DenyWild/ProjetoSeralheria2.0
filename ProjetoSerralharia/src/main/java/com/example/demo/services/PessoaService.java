package com.example.demo.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.entities.Pessoa;
import com.example.demo.model.repositories.PessoaRepository;
import com.example.demo.services.exceptions.EntityNotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
//METODO GET FIND BY ID
	public Pessoa findById(Integer id_pessoa) {
		return pessoaRepository.findById(id_pessoa).orElseThrow(
				() -> new EntityNotFoundException("Id not found "+ id_pessoa));
		
	}
	//METODO POST E PUT NA MESMA FUNÇÃO
	public @ResponseBody Pessoa salvarPessoa (@Valid Pessoa pessoa) {
		pessoaRepository.save(pessoa);
	return pessoa;
}
//METODO GET FIND ALL
public Iterable<Pessoa> consultarPessoas(){
	return pessoaRepository.findAll();
}
//METODO DELETE BY ID
public void excluirPessoaPorId(@PathVariable Integer id_pessoa) {
	pessoaRepository.deleteById(id_pessoa);

}
	
}
