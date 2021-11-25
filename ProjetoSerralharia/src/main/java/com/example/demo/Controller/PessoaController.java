package com.example.demo.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.entities.Pessoa;
import com.example.demo.services.PessoaService;
 @RestController
 @RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
    private PessoaService pessoaService;
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public ResponseEntity<Pessoa> SalvarPessoa (@Valid Pessoa pessoa) {
		Pessoa pes = pessoaService.salvarPessoa(pessoa);
		return ResponseEntity.ok().body(pes);
}


@GetMapping
public Iterable<Pessoa> ConsultarPessoas(){
	return pessoaService.consultarPessoas();
}



@GetMapping(path = "/{id_pessoa}")
public ResponseEntity<Pessoa> ObterPessoaPorId(@PathVariable Integer id_pessoa){
	Pessoa pes = pessoaService.findById(id_pessoa);
	return ResponseEntity.ok().body(pes);
}


@DeleteMapping(path = "/{id_pessoa}")
public void ExcluirPessoaPorId(@PathVariable Integer id_pessoa) {
	pessoaService.excluirPessoaPorId(id_pessoa);

}
	
}
