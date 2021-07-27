package com.caioproject.WebService.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caioproject.WebService.entities.Product;
import com.caioproject.WebService.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository userRepository;

	public List<Product> findAll() {
		return userRepository.findAll();
	}
	
	public Product findById (long id) { // metodo para pesquisa por ID, usa a classe Optional<> com a classe Product como valor, 
		Optional<Product> obj = userRepository.findById(id);
		return obj.get();
	}
}
