package com.projeto.biblioteca.api.book;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "books")
@Entity(name = "Book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String author;
	private int amount;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Enumerated(EnumType.STRING)
	private Format format;
	
	private LocalDate public_date;
	private String description;
	private Boolean activate;
	
	public Book(@Valid BookRegistrationData data) {
		this.activate = true;
		this.title = data.title();
		this.author = data.author();
		this.amount = data.amount();
		this.gender = data.gender();
		this.format = data.format();
		this.public_date = data.public_date();
		this.description = data.description();
	}
	
	public void update(@Valid BookUpdateData data) {
		if(data.title() != null)
			this.title = data.title();
		
		if(data.author() != null)
			this.author = data.author();
		
		if(data.amount() != 0 && data.amount()> 0)
			this.amount = data.amount();
		
		if(data.gender() != null)
			this.gender = data.gender();
		
		if(data.format() != null)
			this.gender = data.gender();
	}
	
	public void inactivate() {
		this.activate = false;
	}

	public void activate() {
		this.activate = true;
	}
	
}
