package com.colutti.restfulSpring.converter.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.colutti.restfulSpring.data.model.Person;
import com.colutti.restfulSpring.data.vo.v2.PersonVOV2;

@Service
public class PersonConverter {
	
	public PersonVOV2 converteEntityToVo(Person person) {
		PersonVOV2 vo = new PersonVOV2();
		vo.setId(person.getId());
		vo.setAddress(person.getAddress());
		vo.setBirthDay(new Date());
		vo.setFirstName(person.getFirstName());
		vo.setLastName(person.getLastName());
		vo.setGender(person.getGender());
		return vo;
	}
	
	public Person converteVoToEntity (PersonVOV2 person) {
		Person entity = new Person();
		entity.setId(person.getId());
		entity.setAddress(person.getAddress());
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setGender(person.getGender());
		return entity;
	}

}
