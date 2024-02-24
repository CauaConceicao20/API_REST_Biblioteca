package com.projeto.biblioteca.api.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressData(
		
		@NotBlank	
		@Pattern(regexp ="\\d{8}")
		String cep,
		
		@NotBlank
		String neighborhood,
		
		@NotBlank
		String city,
		
		String complement,
		String number) {

}
