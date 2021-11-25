package com.example.demo.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.entities.Tecnico;
import com.example.demo.model.repositories.TecnicoRepository;
import com.example.demo.services.exceptions.EntityNotFoundException;

@Service
public class TecnicoService {

	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	//METODO GET FIND BY ID
	public Tecnico findById(Integer id_tecnico) {
	return	tecnicoRepository.findById(id_tecnico).orElseThrow(
				() -> new EntityNotFoundException("Id not found "+ id_tecnico));
	}
	//METODO POST E PUT NA MESMA FUNÇÃO
	public @ResponseBody Tecnico salvarTecnico (@Valid Tecnico tecnico) {
		tecnicoRepository.save(tecnico);
	return tecnico;
}
//METODO GET FIND ALL
public Iterable<Tecnico> consultarTecnicos(){
	return tecnicoRepository.findAll();
}
//METODO DELETE BY ID
public void excluirTecnicpPorId(@PathVariable Integer id_tecnico) {
	tecnicoRepository.deleteById(id_tecnico);

}
}
