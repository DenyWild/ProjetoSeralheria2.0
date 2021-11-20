package com.example.demo.Controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.entities.Pessoa;
import com.example.demo.model.entities.Tecnico;
import com.example.demo.model.repositories.PessoaRepository;
import com.example.demo.model.repositories.TecnicoRepository;

@RestController
@RequestMapping("/tecnico")
public class TecnicoController {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public @ResponseBody Tecnico salvarTecnico (@Valid Tecnico tecnico) {
		tecnicoRepository.save(tecnico);
	return tecnico;
}
	


@GetMapping
public Iterable<Tecnico> consultarTecnicos(){
	return tecnicoRepository.findAll();
}

/*
@GetMapping(path = "/nome/{parteNome}")
public Iterable<Pessoa> ObterClientesPorNome(@PathVariable String parteNome){
	return pessoaRepository.findByNomeContainingIgnoreCase(parteNome);
	
}*/

@GetMapping(path = "/{id_tecnico}")
public Optional<Tecnico> obterTecnicoPorId(@PathVariable Integer id_tecnico){
	return tecnicoRepository.findById(id_tecnico);
}


@DeleteMapping(path = "/{id_tecnico}")
public void excluirTecnicpPorId(@PathVariable Integer id_tecnico) {
	tecnicoRepository.deleteById(id_tecnico);

}
	
}
