package com.udemyjava.demo.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemyjava.demo.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping //método que responde sobre o método Get do HTTP
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "Maria", "maria@gmail.com", "999999999", "12345");
		return ResponseEntity.ok().body(u); //retorna a resposta
	}
}
