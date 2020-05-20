package com.colutti.restfulSpring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colutti.restfulSpring.exception.ResourceNotFoundException;
import com.colutti.restfulSpring.model.Person;
import com.colutti.restfulSpring.repository.PersonRepository;

@Service
public class PersonService {
	
	
	@Autowired
	PersonRepository repository;

	
	public Person create(Person person) {
		
		return repository.save(person);
	}
	
	public Person update(Person person) {
		
		Person entity = repository.
				findById(person.getId()).
				orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return repository.save(entity);
	}
	
	public void delete(Long id) {
		
		Person entity = repository.
				findById(id).
				orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		repository.delete(entity);
		
	}
	
	public Person findById(Long id) {
		
		return repository.
				findById(id).
				orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
	}
	
	public List<Person> findAll(){
		
		return repository.findAll();
		
	}


}
