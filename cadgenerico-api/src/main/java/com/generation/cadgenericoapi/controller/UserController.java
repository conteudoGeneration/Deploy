package com.generation.cadgenericoapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.cadgenericoapi.model.User;
import com.generation.cadgenericoapi.repository.UserRespository;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserRespository repository;
	
	@GetMapping
	public ResponseEntity<List<User>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> GetId(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}
	
	@PostMapping
	public ResponseEntity<User> Post(@RequestBody User user){
		return ResponseEntity.ok(repository.save(user));
	}
	
	@PutMapping
	public ResponseEntity<User> Put(@RequestBody User user){
		return ResponseEntity.ok(repository.save(user));
	}
	
	@DeleteMapping("/{id}")
	public void Delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
}
