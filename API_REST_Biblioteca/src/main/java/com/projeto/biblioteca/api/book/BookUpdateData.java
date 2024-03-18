package com.projeto.biblioteca.api.book;

import jakarta.validation.constraints.NotNull;

public record BookUpdateData(
		
		@NotNull
		Long id,

		String title,
	
		String author,
		
		Gender gender,
		Format format
		) {

}
