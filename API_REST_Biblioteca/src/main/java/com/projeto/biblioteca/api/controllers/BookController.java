package com.projeto.biblioteca.api.controllers;

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
import org.springframework.web.util.UriComponentsBuilder;

import com.projeto.biblioteca.api.book.Book;
import com.projeto.biblioteca.api.book.BookAmountData;
import com.projeto.biblioteca.api.book.BookDetailsData;
import com.projeto.biblioteca.api.book.BookListData;
import com.projeto.biblioteca.api.book.BookRegistrationData;
import com.projeto.biblioteca.api.book.BookUpdateData;
import com.projeto.biblioteca.api.repository.BookRepository;
import com.projeto.biblioteca.api.services.BookService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookRepository repository;
	
	@Autowired
	private BookService service;
	
	@PostMapping("/registerBook")
	@Transactional
	public ResponseEntity<BookDetailsData> registerBook(@RequestBody @Valid BookRegistrationData data, UriComponentsBuilder uriBuilder) {
		var book = new Book(data);
		repository.save(book);
		var uri = uriBuilder.path("/book/{id}").buildAndExpand(book.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new BookDetailsData(book));
	}
	
	@GetMapping("/consultBook/{id}")
	public ResponseEntity<BookDetailsData> consultBook(@PathVariable Long id) {
		var book = repository.findById(id).map(BookDetailsData::new).get();
		
		return ResponseEntity.ok(book);
	}
	
	@GetMapping("/listBooks")
	public ResponseEntity<List<BookListData>> listBooks() {
		var list = repository.findAllByActivateTrue().stream().map(BookListData::new).toList();
		
		return ResponseEntity.ok(list);
	}
	@GetMapping("/listBooksInactives")
	public ResponseEntity<List<BookListData>> listBooksInactive() {
		var list = repository.findAllByActivateFalse().stream().map(BookListData::new).toList();
		
		return ResponseEntity.ok(list);
	}
	
	@PutMapping("/updateBook") 
	@Transactional
	public ResponseEntity<BookDetailsData> updateBook(@RequestBody @Valid BookUpdateData data) {
		var book = repository.getReferenceById(data.id());
		book.update(data);
		
		return ResponseEntity.ok(new BookDetailsData(book));
	}
	
	@PutMapping("/addStock")
	@Transactional
	public ResponseEntity<Void> addStock(@RequestBody @Valid BookAmountData data) {
		service.addQuantity(data.id(), data.amount());
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/removeFromStock")
	@Transactional
	public ResponseEntity<Void> removeFromStock(@RequestBody @Valid BookAmountData data) {
		service.removeQuantity(data.id(), data.amount());
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
		repository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/inactivate/{id}")
	@Transactional
	public ResponseEntity<Void> inactivateBook(@PathVariable Long id) {
		var book = repository.getReferenceById(id);
		book.inactivate();
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/activate/{id}")
	@Transactional
	public ResponseEntity<Void> activateBook(@PathVariable Long id) {
		var book = repository.getReferenceById(id);
		book.activate();
		
		return ResponseEntity.noContent().build();
	}
}
