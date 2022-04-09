package com.udemyjava.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.udemyjava.demo.entities.User;
import com.udemyjava.demo.repositories.UserRepository;
import com.udemyjava.demo.services.exceptions.DatabaseException;
import com.udemyjava.demo.services.exceptions.ResourceNotFoundException;

@Service //regista a classe como componente do Spring para ele conhecer e ser automaticamente injectada (autowired). Existem também o Component e o Repository, para o mesmo fim
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try
		{
			repository.deleteById(id);	
		}
		catch (EmptyResultDataAccessException e)
		{
			throw new ResourceNotFoundException(id);
		}
		catch (DataIntegrityViolationException e)
		{
			throw new DatabaseException(e.getMessage());
		}
		
	}
	
	public User update(Long id, User obj) {
		User entity = repository.getOne(id); //o getOne prepara o objecto pelo JPA (é monitorizado). Desta forma, não há necessidade de ir buscar o objecto à base de dados.
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
