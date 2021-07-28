package com.caioproject.WebService.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping 
	public ResponseEntity<User> insert (@RequestBody User obj) { // inserir recurso ao bando de dados 
		obj = userService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	} // todo esse processo para inserior um novo usario no BD com o ISO 201, 
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete (@PathVariable Long id) {
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}") // anotação para update do uusario com o ID 
	public ResponseEntity<User> update (@PathVariable Long id, @RequestBody User obj) {
		obj = userService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
}
