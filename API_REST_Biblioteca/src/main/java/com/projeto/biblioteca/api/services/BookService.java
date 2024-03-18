package com.projeto.biblioteca.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.biblioteca.api.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository repository;
	
	public void checkStock(Integer amount) {
		if(amount == null) {
			throw new RuntimeException("Campo não deve estar vazio");
		}
	}
	
	public void addQuantity(Long id, int amount) {
		checkStock(amount);
		var book = repository.getReferenceById(id);
		book.addQuantity(amount);
	}
	
	public void removeQuantity(Long id, int amount) {
		checkStock(amount);
		var book = repository.getReferenceById(id);
		book.removeQuantity(amount);
	}
	
}
