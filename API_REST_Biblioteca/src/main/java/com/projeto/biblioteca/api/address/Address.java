package com.projeto.biblioteca.api.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	
	private String cep;
	private String neighborhood;
	private String city;
	private String complement;
	private String number;
}
