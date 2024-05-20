package models;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

public class Item {

	private Long id;
	
	private Long employeeId;
	private String name;
	private Timestamp date;
	
	

	public Item(Long id, Long employeeId, String name, Timestamp date) {
		this.id = id;
		this.employeeId = employeeId;
		this.name = name;
		this.date = date;
	}

	public Item() {
		
	}



	public Item(Long employeeId, String name, Timestamp date) {
		this.employeeId = employeeId;
		this.name = name;
		this.date = date;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", employeeId=" + employeeId + ", name=" + name + ", date=" + date + "]";
	}

}
