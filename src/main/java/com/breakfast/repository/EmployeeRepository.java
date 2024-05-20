package com.breakfast.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.breakfast.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	@Query(value = "INSERT INTO EMPLOYEE (EMP_NAME, EMP_CPF) VALUES (:EMP_NAME, :EMP_CPF);", nativeQuery = true)
	public Employee save(Employee employee);

	@Query(value = "DELETE FROM EMPLOYEE WHERE EMP_ID = ?;", nativeQuery = true)
	public void deleteById(Long id);
	
	@Query(value = "UPDATE EMPLOYEE SET EMP_NAME = ?, EMP_CPF = ? WHERE USR_ID = ?;", nativeQuery = true)
	public void update(Employee employee);
	
	@Query(value = "SELECT * FROM EMPLOYEE WHERE EMP_ID = ?;", nativeQuery = true)
	public Employee getById(Long id);
	
	@Query(value = "SELECT * FROM EMPLOYEE;", nativeQuery = true)
	public List<Employee> findAll();
	
}
