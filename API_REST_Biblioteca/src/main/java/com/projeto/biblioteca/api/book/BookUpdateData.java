package com.projeto.biblioteca.api.book;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record BookUpdateData(
		
		@NotNull
		Long id,

		String title,
	
		String author,
		
		@Positive
		int amount,

		Gender gender,
		Format format
		) {

}
