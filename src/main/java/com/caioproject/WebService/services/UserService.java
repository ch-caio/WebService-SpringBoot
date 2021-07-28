package com.caioproject.WebService.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.caioproject.WebService.entities.User;
import com.caioproject.WebService.repositories.UserRepository;
import com.caioproject.WebService.services.exceptions.DatabaseException;
import com.caioproject.WebService.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(long id) { // metodo para pesquisa por ID, usa a classe Optional<> com a classe User como
									// valor,
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User obj) { // inserir no banco de dados um novo objeto tipo User
		return userRepository.save(obj);
	}

	public void delete (Long id) {
		try { // mensagem de erro caso tentar deletar ID que nao existe 
		userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e ) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public User update(Long id, User obj) { // fazer o update do usuario
		User entity = userRepository.getOne(id);
		updateData(entity, obj); // chama o metodo de baixo e atualiza os campos que esta escrito
		return userRepository.save(entity); // salva os novos dados
	}

	private void updateData(User entity, User obj) { // fazer o update do usuario nos campos escrito
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
