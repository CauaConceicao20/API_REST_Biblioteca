package com.projeto.biblioteca.api.address;

public record AddressData(
		String cep,
		String neighborhood,
		String city,
		String complement,
		String number) {

}
