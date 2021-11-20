package com.example.demo.model.repositories;

import javax.validation.Valid;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.entities.Tecnico;

public interface TecnicoRepository extends CrudRepository<Tecnico, Integer> {

	

	
}
