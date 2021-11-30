package com.example.demo.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.entities.Tecnico;
import com.example.demo.services.TecnicoService;

@RestController
@RequestMapping("/tecnico")
public class TecnicoController {

	@Autowired
	private TecnicoService tecnicoService;
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public ResponseEntity<Tecnico> SalvarTecnico (@RequestBody @Valid Tecnico tecnico) {
	Tecnico tec = tecnicoService.salvarTecnico(tecnico);
	return ResponseEntity.ok().body(tec);
}
	


@GetMapping
public Iterable<Tecnico> ConsultarTecnicos(){
	return tecnicoService.consultarTecnicos();
}

/*
@GetMapping(path = "/nome/{parteNome}")
public Iterable<Pessoa> ObterClientesPorNome(@PathVariable String parteNome){
	return pessoaRepository.findByNomeContainingIgnoreCase(parteNome);
	
}*/

@GetMapping(path = "/{id_tecnico}")
public ResponseEntity<Tecnico> ObterTecnicoPorId(@PathVariable Integer id_tecnico){
	Tecnico tec = tecnicoService.findById(id_tecnico);
	return ResponseEntity.ok().body(tec);
}


@DeleteMapping(path = "/{id_tecnico}")
public void ExcluirTecnicpPorId(@PathVariable Integer id_tecnico) {
	tecnicoService.excluirTecnicpPorId(id_tecnico);

}
	
}
