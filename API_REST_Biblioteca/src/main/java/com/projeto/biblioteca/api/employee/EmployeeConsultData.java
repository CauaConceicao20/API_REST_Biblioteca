package com.projeto.biblioteca.api.employee;

import java.util.Optional;

import com.projeto.biblioteca.api.address.Address;

public record EmployeeConsultData(Long id, String name, String email, String cpf, Address address ) {
	
	public EmployeeConsultData(Optional<Employee> employee) {
		this(employee.get().getId(),
			 employee.get().getName(),
			 employee.get().getEmail(),
			 employee.get().getCpf(),
			 employee.get().getAddress());
	}
}
