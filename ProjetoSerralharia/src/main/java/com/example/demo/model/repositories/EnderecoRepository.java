package com.example.demo.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.model.entities.Endereco;

public interface EnderecoRepository extends PagingAndSortingRepository<Endereco, Integer>{

}
