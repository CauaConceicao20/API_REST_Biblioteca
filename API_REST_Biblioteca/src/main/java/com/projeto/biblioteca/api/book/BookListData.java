package com.projeto.biblioteca.api.book;

import java.time.LocalDate;

public record BookListData(Long id, String title, String author, int amount, Gender gender, Format format, LocalDate public_date, String description) {
	
	public BookListData(Book book) {
		this(book.getId(),
				 book.getTitle(),
				 book.getAuthor(),
				 book.getAmount(),
				 book.getGender(),
				 book.getFormat(),
				 book.getPublic_date(),
				 book.getDescription()
				 );
	}
}
