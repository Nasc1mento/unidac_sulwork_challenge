package controllers;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.Employee;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@GetMapping
	public Employee find(@PathVariable Long id) {
		return null;
	}

	@PostMapping
	public List<Employee> findAll() {
		return null;
	}

	@PutMapping
	public Employee update(@PathVariable Long id, @RequestBody JSONObject employee) {
		return null;
	}

	@DeleteMapping
	public Employee delete(@PathVariable Long id) {
		return null;
	}
}
