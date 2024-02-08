package com.example.test.EmployeeDetails.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.test.EmployeeDetails.Dto.EmployeeDetailsDto;
import com.example.test.EmployeeDetails.Dto.TaxDeductionDTO;

@Service
public interface EmployeeService {
	
	EmployeeDetailsDto saveEmployee(EmployeeDetailsDto employee);

	List<TaxDeductionDTO> calculateTaxDeduction(); 

}
