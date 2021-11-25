package com.example.demo.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.entities.Pedido;
import com.example.demo.services.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT} )
	public  ResponseEntity<Pedido> SalvarPedido(@Valid Pedido pedido) {
		Pedido ped = pedidoService.salvarPedido(pedido);
		return ResponseEntity.ok().body(ped);
		
	}
	@GetMapping
	public Iterable<Pedido> ConsultarPedidos(){
		return pedidoService.consultarPedidos();
	}
	
	@GetMapping(path = "/{id_pedido}")
	public ResponseEntity<Pedido> ConsultarPedidoporId(@PathVariable Integer id_pedido){
		Pedido ped = pedidoService.findById(id_pedido);
		return ResponseEntity.ok().body(ped);
		
	}
	@DeleteMapping(path = "/{id_pedido}")
	public void ExcluirPedido(@PathVariable Integer id_pedido) {
		pedidoService.excluirPedido(id_pedido);
	}
}
