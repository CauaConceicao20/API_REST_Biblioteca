package com.projeto.biblioteca.api.employee;

import org.hibernate.validator.constraints.br.CPF;

import com.projeto.biblioteca.api.address.AddressData;
import com.projeto.biblioteca.api.services.CpfAlreadyRegistered;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmployeeRegisterData(
		@NotBlank
		String name,
		
		@NotBlank
		@Email
		String email,
		
		@CPF
		@CpfAlreadyRegistered
		String cpf,
		
		@NotNull
		Specialty specialty,
		
		@NotNull
		@Valid
		AddressData address
		) {

}
