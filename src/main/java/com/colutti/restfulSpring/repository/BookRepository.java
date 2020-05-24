package com.colutti.restfulSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colutti.restfulSpring.data.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
