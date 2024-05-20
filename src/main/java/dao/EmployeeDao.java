package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.IDatabase;
import database.MySQLDatabase;
import models.Employee;

public class EmployeeDao implements IDao<Employee> {

	private IDatabase database;
	private static EmployeeDao instance;

	private EmployeeDao() {
		this.database = new MySQLDatabase();
	}

	public static EmployeeDao getInstance() {
		if (instance == null) {
			return new EmployeeDao();
		}

		return instance;
	}

	@Override
	public void save(Employee employee) {

		String query = "INSERT INTO EMPLOYEE VALUES (?, ?);";

		try {
			PreparedStatement ps = this.database.getConnection().prepareStatement(query);
			ps.setLong(1, employee.getId());
			ps.setString(2, employee.getName());
			ps.setString(3, employee.getCpf());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Employee get(Long id) {
		Employee employee = new Employee();
		String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = ?;";

		try {
			PreparedStatement ps = this.database.getConnection().prepareStatement(query);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();

			employee.setId(rs.getLong("EMP_ID"));
			employee.setName(rs.getString("EMP_NAME"));
			employee.setCpf(rs.getString("EMP_CPF"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public void update(Employee employee) {
		String query = "UPDATE EMPLOYEE SET EMP_NAME = ?, EMP_CPF = ? WHERE USR_ID = ?;";
		try {
			PreparedStatement ps = this.database.getConnection().prepareStatement(query);
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getCpf());
			ps.setLong(3, employee.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> employees = new ArrayList<Employee>();
		String query = "SELECT * FROM EMPLOYEE;";

		try {
			PreparedStatement ps = this.database.getConnection().prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Long id = rs.getLong("EMP_ID");
				String name = rs.getString("EMP_CPF");
				String cpf = rs.getString("EMP_CPF");
				Employee employee = new Employee(id, name, cpf);
				employees.add(employee);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public void delete(Long id) {
		String query = "DELETE FROM EMPLOYEE WHERE EMP_ID = ?;";
		try {
			
			PreparedStatement preparedStatement = this.database.getConnection().prepareStatement(query);
			preparedStatement.setLong(1, id);
			preparedStatement.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
