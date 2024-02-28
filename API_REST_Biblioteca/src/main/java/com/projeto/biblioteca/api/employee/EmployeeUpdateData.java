package com.projeto.biblioteca.api.employee;

import com.projeto.biblioteca.api.address.AddressData;

import jakarta.validation.constraints.NotNull;

public record EmployeeUpdateData(
		
		@NotNull
		Long id,
		
		String name,
		
		String email,
		
		AddressData address) {

}
