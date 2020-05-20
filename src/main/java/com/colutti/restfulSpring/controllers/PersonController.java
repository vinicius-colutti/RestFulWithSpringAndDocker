package com.colutti.restfulSpring.controllers;

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

import com.colutti.restfulSpring.model.Person;
import com.colutti.restfulSpring.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService services;
	
	@GetMapping
	public List<Person> findAll(){
		
		return services.findAll();
		
	}
	
	@GetMapping("/{id}")
	public Person findById(@PathVariable("id") Long id){
		
		return services.findById(id);
		
	}
	
	@PostMapping
	public Person create(@RequestBody Person person){
		
		return services.create(person);
		
	}
	
	@PutMapping
	public Person update(@RequestBody Person person){
		
		return services.update(person);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		
		services.delete(id);
		return ResponseEntity.ok().build();
		
	}
	
	
}
