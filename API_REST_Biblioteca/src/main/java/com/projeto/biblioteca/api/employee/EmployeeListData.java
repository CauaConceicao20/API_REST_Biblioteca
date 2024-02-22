package com.projeto.biblioteca.api.employee;

public record EmployeeListData(String name, Specialty specialty) {
	
	public EmployeeListData(Employee employee) {
		this(employee.getName(),
			 employee.getSpecialty()
			 );
		}
}
