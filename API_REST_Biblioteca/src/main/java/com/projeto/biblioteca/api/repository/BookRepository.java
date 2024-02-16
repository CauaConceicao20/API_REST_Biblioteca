package com.projeto.biblioteca.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.biblioteca.api.book.Book;


public interface BookRepository extends JpaRepository<Book, Long>{

	List<Book> findAllByActivateTrue();

	List<Book> findAllByActivateFalse();

}
