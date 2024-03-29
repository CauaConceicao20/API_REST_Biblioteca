package com.projeto.biblioteca.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.biblioteca.api.employee.Employee;



public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	Optional<Employee> findByCpf(String cpf);

	List<Employee> findAllByActivateTrue();

	List<Employee> findAllByActivateFalse();

	Optional<Employee> findByEmail(String email);
	



}
