package com.breakfast.services;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.breakfast.models.Employee;
import com.breakfast.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService {

	final EmployeeRepository repository;

	public EmployeeService(EmployeeRepository repository) {
		this.repository = repository;
	}

	public Employee findOne(Long id) {
		return this.repository.getById(id);
	}

	public List<Employee> findAll() {
		return this.repository.findAll();
	}
	
	@Transactional
	public void delete(Long id) {
		this.repository.deleteById(id);
	}

	public void update() {

	}
	
	@Transactional
	public Employee save(Employee e) {
		return this.repository.save(e);
	}

}
