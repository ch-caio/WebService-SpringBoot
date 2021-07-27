package com.caioproject.WebService.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caioproject.WebService.entities.User;
import com.caioproject.WebService.services.UserService;

@RestController // marca a classe como um controlador, onde cada método retorna um objeto de domínio
@RequestMapping(value="/users") // endereço na barra de pesquisa para a classe users
public class UserResource {

	@Autowired
	private UserService userService; // estancia a classe
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() { // ResponseEntity representar toda a resposta HTTP. Você pode controlar qualquer coisa que aconteça: código de status, cabeçalhos e corpo.
		List<User> list = userService.findAll(); // chamo o metodo findAll da classe UserService
		return ResponseEntity.ok().body(list); // retorna a classe como lista 
	}
	
	@GetMapping(value = "/{id}") 
	public ResponseEntity<User> findById (@PathVariable Long id) { // @PathVariable serve para o spring identificar o id como argumento
		User obj = userService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
