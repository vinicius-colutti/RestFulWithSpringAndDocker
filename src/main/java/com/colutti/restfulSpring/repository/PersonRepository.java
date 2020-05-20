package com.colutti.restfulSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colutti.restfulSpring.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
