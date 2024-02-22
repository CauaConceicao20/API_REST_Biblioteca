package com.projeto.biblioteca.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.projeto.biblioteca.api.employee.Employee;
import com.projeto.biblioteca.api.employee.EmployeeDetailsData;
import com.projeto.biblioteca.api.employee.EmployeeListData;
import com.projeto.biblioteca.api.employee.EmployeeRegisterData;
import com.projeto.biblioteca.api.repository.EmployeeRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository repository;
	
	@PostMapping("/registerEmployee")
	@Transactional
	public ResponseEntity<EmployeeDetailsData> registerEmployee(@RequestBody @Valid EmployeeRegisterData data, UriComponentsBuilder uriBuilder ) {
		var employee = new Employee(data);
		repository.save(employee);
		var uri = uriBuilder.path("/employee/{id}").buildAndExpand(employee.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new EmployeeDetailsData(employee));
	}
	
	@GetMapping("/listEmployee")
	public ResponseEntity<List<EmployeeListData>> listEmployees() {
		var list = repository.findAll().stream().map(EmployeeListData::new).toList();
	
		return ResponseEntity.ok(list);
	}
}