package com.projeto.biblioteca.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.projeto.biblioteca.api.employee.Employee;
import com.projeto.biblioteca.api.employee.EmployeeConsultData;
import com.projeto.biblioteca.api.employee.EmployeeDetailsData;
import com.projeto.biblioteca.api.employee.EmployeeListData;
import com.projeto.biblioteca.api.employee.EmployeeRegisterData;
import com.projeto.biblioteca.api.employee.EmployeeUpdateData;
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
		var list = repository.findAllByActivateTrue().stream().map(EmployeeListData::new).toList();

		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/listEmployeesInatives")
	public ResponseEntity<List<EmployeeListData>> ListEmployeesInactives() {
		var list = repository.findAllByActivateFalse().stream().map(EmployeeListData::new).toList();
		
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/consultEmployee/{cpf}")
	public ResponseEntity<EmployeeConsultData> consultEmployee(@PathVariable String cpf) {
		var employee = repository.findByCpf(cpf); 
		
		return ResponseEntity.ok(new EmployeeConsultData(employee));
	}
	
	@PutMapping("/updateEmployee")
	@Transactional
	public ResponseEntity<EmployeeDetailsData> updateEmployee(@RequestBody @Valid EmployeeUpdateData data) {
		var employee = repository.getReferenceById(data.id());
		employee.employeeUpdateData(data);
		
		return ResponseEntity.ok(new EmployeeDetailsData(employee));
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<Void> Deleteemployee(@PathVariable Long id) {
		repository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/inactivateEmployee/{id}")
	@Transactional
	public ResponseEntity<?> inactivateEmployee(@PathVariable Long id) {
		var employee = repository.getReferenceById(id);
		employee.inactivate();
		
		return ResponseEntity.ok(employee);
	}
	
	@PutMapping("/reactiveEmployee/{id}")
	@Transactional
	public ResponseEntity<?> reactivateEmployee(@PathVariable Long id) {
		var employee = repository.getReferenceById(id);
		employee.reactivate();
		
		return ResponseEntity.ok(employee);
	}
	
}
