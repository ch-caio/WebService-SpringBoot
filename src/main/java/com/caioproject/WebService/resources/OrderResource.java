package com.caioproject.WebService.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caioproject.WebService.entities.Order;
import com.caioproject.WebService.services.OrderService;

@RestController // marca a classe como um controlador, onde cada método retorna um objeto de domínio
@RequestMapping(value="/orders") // endereço na barra de pesquisa para a classe users
public class OrderResource {

	@Autowired
	private OrderService userService; // estancia a classe
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll() { // ResponseEntity representar toda a resposta HTTP. Você pode controlar qualquer coisa que aconteça: código de status, cabeçalhos e corpo.
		List<Order> list = userService.findAll(); // chamo o metodo findAll da classe OrderService
		return ResponseEntity.ok().body(list); // retorna a classe como lista 
	}
	
	@GetMapping(value = "/{id}") 
	public ResponseEntity<Order> findById (@PathVariable Long id) { // @PathVariable serve para o spring identificar o id como argumento
		Order obj = userService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
