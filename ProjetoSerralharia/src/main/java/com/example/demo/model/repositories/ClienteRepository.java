package com.example.demo.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.entities.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer>{

}
