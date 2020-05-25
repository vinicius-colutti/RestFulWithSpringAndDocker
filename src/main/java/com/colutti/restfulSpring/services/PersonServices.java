package com.colutti.restfulSpring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.colutti.restfulSpring.converter.DozerConverter;
import com.colutti.restfulSpring.converter.custom.PersonConverter;
import com.colutti.restfulSpring.data.model.Person;
import com.colutti.restfulSpring.data.vo.PersonVO;
import com.colutti.restfulSpring.data.vo.v2.PersonVOV2;
import com.colutti.restfulSpring.exception.ResourceNotFoundException;
import com.colutti.restfulSpring.repository.PersonRepository;

@Service
public class PersonServices {
	
	
	@Autowired
	PersonRepository repository;
	
	@Autowired
	PersonConverter converter;

	
	public PersonVO create(PersonVO person) {
		Person entity = DozerConverter.parseObject(person, Person.class);
		PersonVO vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public PersonVOV2 createV2(PersonVOV2 person) {
		Person entity = converter.converteVoToEntity(person);
		PersonVOV2 vo = converter.converteEntityToVo(repository.save(entity));
		return vo;
	}
	
	public PersonVO update(PersonVO person) {
		
		Person entity = repository.
				findById(person.getKey()).
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
	
	@Transactional
	public PersonVO disablePerson(Long id) {
		Person entity = repository.
				findById(id).
				orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		repository.disablePerson(entity.getId());
		
		return DozerConverter.parseObject(entity, PersonVO.class);
	}
	
	public PersonVO findById(Long id) {
		
		Person entity = repository.
				findById(id).
				orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		return DozerConverter.parseObject(entity, PersonVO.class);
	}
	
	public Page<PersonVO> findAll(Pageable pageable){
		
		Page<Person> page = repository.findAll(pageable);
		
		return page.map(this::convertToPersonVO);
		
	}
	
	public Page<PersonVO> findPersonByName(String firstName, Pageable pageable){
		
		Page<Person> page = repository.findPersonByName(firstName, pageable);
		
		return page.map(this::convertToPersonVO);
		
	}
	
	private PersonVO convertToPersonVO(Person entity) {
		return DozerConverter.parseObject(entity, PersonVO.class);
	}


}
