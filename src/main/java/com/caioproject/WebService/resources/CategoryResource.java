package com.caioproject.WebService.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caioproject.WebService.entities.Category;
import com.caioproject.WebService.services.CategoryService;

@RestController // marca a classe como um controlador, onde cada método retorna um objeto de domínio
@RequestMapping(value="/categories") // endereço na barra de pesquisa para a classe users
public class CategoryResource {

	@Autowired
	private CategoryService userService; // estancia a classe
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll() { // ResponseEntity representar toda a resposta HTTP. Você pode controlar qualquer coisa que aconteça: código de status, cabeçalhos e corpo.
		List<Category> list = userService.findAll(); // chamo o metodo findAll da classe CategoryService
		return ResponseEntity.ok().body(list); // retorna a classe como lista 
	}
	
	@GetMapping(value = "/{id}") 
	public ResponseEntity<Category> findById (@PathVariable Long id) { // @PathVariable serve para o spring identificar o id como argumento
		Category obj = userService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
