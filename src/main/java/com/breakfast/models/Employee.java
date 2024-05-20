package com.breakfast.models;

import java.io.Serial;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "EMPLOYEE")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = "id")
public class Employee {
	
   @Serial
   private static final long serialVersionUID = 1L;
	
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMP_ID")
	 private Long id;

	@Column(name = "EMP_NAME",nullable = false)
	private String name;
	
	@Column(name = "EMP_CPF", nullable = false)
	private String cpf;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	

}
