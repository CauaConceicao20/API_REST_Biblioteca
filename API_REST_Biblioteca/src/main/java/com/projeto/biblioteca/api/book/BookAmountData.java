package com.projeto.biblioteca.api.book;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record BookAmountData(
		@NotNull
		Long id, 
		@Positive
		int amount
		) {

}
