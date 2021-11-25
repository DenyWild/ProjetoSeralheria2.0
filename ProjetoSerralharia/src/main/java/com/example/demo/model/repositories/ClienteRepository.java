package com.example.demo.model.repositories;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.model.entities.Cliente;

public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Integer>{
	
	public Iterable<Cliente> findByNomeContainingIgnoreCase(String parteNome);

 public  Optional<Cliente> findByCpf(String cpf);
}
