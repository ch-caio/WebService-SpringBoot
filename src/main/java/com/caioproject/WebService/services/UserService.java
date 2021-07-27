package com.caioproject.WebService.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caioproject.WebService.entities.User;
import com.caioproject.WebService.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById (long id) { // metodo para pesquisa por ID, usa a classe Optional<> com a classe User como valor, 
		Optional<User> obj = userRepository.findById(id);
		return obj.get();
	}
}
