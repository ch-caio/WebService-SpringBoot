package com.caioproject.WebService.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caioproject.WebService.entities.Category;
import com.caioproject.WebService.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository userRepository;

	public List<Category> findAll() {
		return userRepository.findAll();
	}
	
	public Category findById (long id) { // metodo para pesquisa por ID, usa a classe Optional<> com a classe Category como valor, 
		Optional<Category> obj = userRepository.findById(id);
		return obj.get();
	}
}
