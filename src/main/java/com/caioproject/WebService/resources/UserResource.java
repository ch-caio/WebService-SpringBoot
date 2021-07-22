package com.caioproject.WebService.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caioproject.WebService.entities.User;

@RestController // marca a classe como um controlador, onde cada método retorna um objeto de domínio
@RequestMapping(value="/users") // endereço na barra de pesquisa para a classe users
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "Maria", "maria@gmail.com", "123456789", "123");
		return ResponseEntity.ok().body(u);
	}
}
