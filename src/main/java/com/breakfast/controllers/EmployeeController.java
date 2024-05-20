package com.breakfast.controllers;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.breakfast.dto.EmployeeDTO;
import com.breakfast.models.Employee;
import com.breakfast.services.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EmployeeController {

	final EmployeeService service;

	public EmployeeController(EmployeeService service) {
		this.service = service;
	}

	@PostMapping
	@ResponseBody
	public ResponseEntity<Employee> create(@RequestBody @Valid EmployeeDTO employeeDTO) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeDTO, employee);
		return 		ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(employee));
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Employee> find(@PathVariable Long id) {
		Employee employee = this.service.findOne(id);
		return ResponseEntity.ok(employee);
	}

	@GetMapping
	public ResponseEntity<List<Employee>> findAll() {

		return ResponseEntity.ok(this.service.findAll());
	}

	@PutMapping(path = "/{id}", produces = { "application/json" })
	public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody JSONObject employee) {
		return null;
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id) {
		try {
			this.service.delete(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
