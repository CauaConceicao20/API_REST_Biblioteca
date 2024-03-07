package com.projeto.biblioteca.api.employee;

public record EmployeeListData(Long id, String name, String email,Specialty specialty) {
	
	public EmployeeListData(Employee employee) {
		this(employee.getId(),
			 employee.getName(),
			 employee.getEmail(),
			 employee.getSpecialty()
			 );
		}
}
