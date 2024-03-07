package com.projeto.biblioteca.api.employee;

import com.projeto.biblioteca.api.address.AddressData;
import com.projeto.biblioteca.api.services.CheckIfEmailIsValid;
import com.projeto.biblioteca.api.services.EmailAlreadyRegistered;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record EmployeeUpdateData(
		
		@NotNull
		Long id,
		
		String name,
		
		@Email
		@CheckIfEmailIsValid
		@EmailAlreadyRegistered
		String email,
		
		AddressData address) {

}
