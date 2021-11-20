package com.example.demo.Controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.entities.Pedido;
import com.example.demo.model.repositories.PedidoRepository;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT} )
	public @ResponseBody Pedido SalvarPeido(@Valid Pedido pedido) {
		pedidoRepository.save(pedido);
		return pedido;
		
	}
	@GetMapping
	public Iterable<Pedido> ConsultarPedidos(){
		return pedidoRepository.findAll();
	}
	
	@GetMapping(path = "/{id_pedido}")
	public Optional<Pedido> ConsultarPedidoporId(@PathVariable Integer id_pedido){
		return pedidoRepository.findById(id_pedido);
		
	}
	@DeleteMapping(path = "/{id_pedido}")
	public void ExcluirPedido(@PathVariable Integer id_pedido) {
		pedidoRepository.deleteById(id_pedido);
	}
}
