package com.caioproject.WebService.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caioproject.WebService.entities.Order;
import com.caioproject.WebService.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository userRepository;

	public List<Order> findAll() {
		return userRepository.findAll();
	}
	
	public Order findById (long id) { // metodo para pesquisa por ID, usa a classe Optional<> com a classe Order como valor, 
		Optional<Order> obj = userRepository.findById(id);
		return obj.get();
	}
}
