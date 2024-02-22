package com.projeto.biblioteca.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.biblioteca.api.employee.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
