package com.projeto.biblioteca.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.projeto.biblioteca.api.employee.Employee;
import com.projeto.biblioteca.api.repository.EmployeeRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidation implements ConstraintValidator<EmailAlreadyRegistered, String>{

	@Autowired
	private EmployeeRepository repository;
	
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		if(email == null || repository == null) {
			return true;
		}
		Optional<Employee> employeeExisting = repository.findByEmail(email); 
		return !employeeExisting.isPresent();	
	}

}
