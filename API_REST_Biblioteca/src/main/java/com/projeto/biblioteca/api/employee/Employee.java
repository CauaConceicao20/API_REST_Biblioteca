package com.projeto.biblioteca.api.employee;

import org.hibernate.validator.constraints.br.CPF;

import com.projeto.biblioteca.api.address.Address;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "employees")
@Entity(name = "Employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Email
	private String email;
	
	@CPF
	private String cpf;
	
	@Enumerated(EnumType.STRING)
	private Specialty specialty;
	
	@Embedded
	private Address address;
	
	
	public Employee(EmployeeRegisterData data) {
		this.name = data.name();
		this.email = data.email();
		this.cpf = data.cpf();
		this.specialty = data.specialty();
		this.address = new Address(data.address());
	}
}
