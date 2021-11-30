package com.example.demo.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.entities.Pedido;
import com.example.demo.model.repositories.PedidoRepository;
import com.example.demo.services.exceptions.EntityNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	//METODO GET FIND BY ID
	public Pedido findById(Integer id_pedido) {
		return pedidoRepository.findById(id_pedido).orElseThrow(
				() -> new EntityNotFoundException("Id not found "+id_pedido));
	
	}
	
	//METODO POST E PUT NA MESMA FUNÇÃO 
	public @ResponseBody Pedido salvarPedido(@RequestBody Pedido pedido) throws IllegalAccessException
	{
		Pedido result = null;

		Pedido atual = this.pedidoRepository.save(pedido);
		result = atual;
		result.setTipoPedido(pedido.getTipoPedido());
		result.setDatapedido(pedido.getDatapedido());
		return this.pedidoRepository.save(result);
		
	}
   //METODO GET FIND ALL
	public Iterable<Pedido> consultarPedidos(){
		return pedidoRepository.findAll();
	}
	//METODO DELETE BY ID
	public void excluirPedido(@PathVariable Integer id_pedido) {
		pedidoRepository.deleteById(id_pedido);
	}
}
