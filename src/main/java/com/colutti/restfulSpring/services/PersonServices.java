package com.colutti.restfulSpring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colutti.restfulSpring.converter.DozerConverter;
import com.colutti.restfulSpring.data.model.Person;
import com.colutti.restfulSpring.data.vo.PersonVO;
import com.colutti.restfulSpring.exception.ResourceNotFoundException;
import com.colutti.restfulSpring.repository.PersonRepository;

@Service
public class PersonServices {
	
	
	@Autowired
	PersonRepository repository;

	
	public PersonVO create(PersonVO person) {
		Person entity = DozerConverter.parseObject(person, Person.class);
		PersonVO vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public PersonVO update(PersonVO person) {
		
		Person entity = repository.
				findById(person.getId()).
				orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		PersonVO vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		
		Person entity = repository.
				findById(id).
				orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		repository.delete(entity);
		
	}
	
	public PersonVO findById(Long id) {
		
		Person entity = repository.
				findById(id).
				orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		return DozerConverter.parseObject(entity, PersonVO.class);
	}
	
	public List<PersonVO> findAll(){
		
		return DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);
		
	}


}
