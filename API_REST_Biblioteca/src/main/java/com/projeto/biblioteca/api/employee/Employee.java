package com.projeto.biblioteca.api.employee;

import com.projeto.biblioteca.api.address.Address;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "employee")
@Entity(name = "Employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String email;
	private String cpf;
	
	@Enumerated(EnumType.STRING)
	private Specialty specialty;
	
	@Embedded
	private Address address;
	
	private boolean activate;
	
	
	public Employee(EmployeeRegisterData data) {
		this.name = data.name();
		this.email = data.email();
		this.cpf = data.cpf();
		this.specialty = data.specialty();
		this.address = new Address(data.address());
		this.activate = true;
	}
	
	public void inactivate() {
		this.activate = false;
	}
	
	public void reactivate() {
		this.activate = true;
		
	}	
	
	public void employeeUpdateData(EmployeeUpdateData data) {
		if(data.name()!= null) {
			this.name = data.name();
		}
		
		if(data.email() != null) {
			this.email = data.email();
		}
		
		if(data.address() != null) {
			this.address = new Address(data.address());
		}
	}	
}
