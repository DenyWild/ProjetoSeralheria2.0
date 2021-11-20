package com.example.demo.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.entities.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Integer>{

	

}
