package com.breakfast.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmployeeDTO {
	
	
	@NotNull
	private String name;
	
	@NotNull
	private String cpf;
}
