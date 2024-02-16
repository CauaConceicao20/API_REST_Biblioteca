package com.projeto.biblioteca.api.book;

import java.time.LocalDate;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;

public record BookRegistrationData(
		
		@NotBlank
		String title,
		
		@NotBlank
		String author,
		
		@Positive
		int amount,
		
		@Enumerated
		Gender gender,
		
		@Enumerated
		Format format,
		
		@Past
		LocalDate public_date,
		
		@NotBlank
		String description
		) {

}
