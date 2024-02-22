package com.projeto.biblioteca.api.employee;

import com.projeto.biblioteca.api.address.Address;

public record EmployeeDetailsData(Long id, String name, String email, String cpf, Specialty specialty, Address address) {
	
	public EmployeeDetailsData(Employee employee) {
		this(employee.getId(),
			 employee.getName(),
			 employee.getEmail(),
			 employee.getCpf(),
			 employee.getSpecialty(),
			 employee.getAddress()
			 );
	}
}
