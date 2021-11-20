package com.example.demo.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.entities.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Integer>{

}
