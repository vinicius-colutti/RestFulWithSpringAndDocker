package com.colutti.restfulSpring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colutti.restfulSpring.converter.DozerConverter;
import com.colutti.restfulSpring.data.model.Book;
import com.colutti.restfulSpring.data.vo.BookVO;
import com.colutti.restfulSpring.exception.ResourceNotFoundException;
import com.colutti.restfulSpring.repository.BookRepository;

@Service
public class BookServices {
	
	
	@Autowired
	BookRepository repository;

	
	public BookVO create(BookVO book) {
		Book entity = DozerConverter.parseObject(book, Book.class);
		BookVO vo = DozerConverter.parseObject(repository.save(entity), BookVO.class);
		return vo;
	}
	
	
	public BookVO update(BookVO book) {
		
		Book entity = repository.
				findById(book.getKey()).
				orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		entity.setAuthor(book.getAuthor());
		entity.setLaunchDate(book.getLaunchDate());
		entity.setPrice(book.getPrice());
		entity.setTitle(book.getTitle());
		
		BookVO vo = DozerConverter.parseObject(repository.save(entity), BookVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		
		Book entity = repository.
				findById(id).
				orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		repository.delete(entity);
		
	}
	
	public BookVO findById(Long id) {
		
		Book entity = repository.
				findById(id).
				orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		return DozerConverter.parseObject(entity, BookVO.class);
	}
	
	public List<BookVO> findAll(){
		
		return DozerConverter.parseListObjects(repository.findAll(), BookVO.class);
		
	}


}
