package com.example.test.EmployeeDetails.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.test.EmployeeDetails.Dto.EmployeeDetailsDto;
import com.example.test.EmployeeDetails.Dto.TaxDeductionDTO;
import com.example.test.EmployeeDetails.Exception.EmployeeValidationException;
import com.example.test.EmployeeDetails.Repository.EmployeeRepository;

public class EmployeeServiceimpl  implements EmployeeService {

	
	 @Autowired
	    private EmployeeRepository employeeRepository; 
	@Override
	public EmployeeDetailsDto saveEmployee(EmployeeDetailsDto employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}
	
	private void validateEmployee(EmployeeDetailsDto employeeDTO) throws EmployeeValidationException {
        // Implement validation logic
        if (employeeDTO.getEmployeeId() == null || employeeDTO.getFirstName() == null ||
            employeeDTO.getLastName() == null || employeeDTO.getEmail() == null ||
            employeeDTO.getPhoneNumber() == null || employeeDTO.getDoj() == null ||
            employeeDTO.getSalary() == null) {
            throw new EmployeeValidationException("All fields are mandatory");
        }

       
    
}

	public List<Object> calculateTaxDeduction() {
        List<EmployeeDetailsDto> employees = employeeRepository.getAllEmployees(); // Assuming you have a method to fetch all employees
        return employees.stream()
                .map(this::calculateTaxDeductionForEmployee1)
                .collect(Collectors.toList());
    }

    private TaxDeductionDTO calculateTaxDeductionForEmployee1(TaxDeductionDTO employeeDTO) {
        TaxDeductionDTO taxDeductionDTO = new TaxDeductionDTO();
        taxDeductionDTO.setEmployeeCode(employeeDTO.getEmployeeCode());
        taxDeductionDTO.setFirstName(employeeDTO.getFirstName());
        taxDeductionDTO.setLastName(employeeDTO.getLastName());
        taxDeductionDTO.setYearlySalary(calculateYearlySalary(employeeDTO));
        double taxableIncome = taxDeductionDTO.getYearlySalary() - 250000; 
        double taxAmount = 0.0;

        if (taxableIncome > 0) {
            if (taxableIncome <= 250000) {
                taxAmount = 0.05 * taxableIncome; 
            } else if (taxableIncome <= 500000) {
                taxAmount = 0.05 * 250000 + 0.1 * (taxableIncome - 250000); 
            } else if (taxableIncome <= 1000000) {
                taxAmount = 0.05 * 250000 + 0.1 * 250000 + 0.2 * (taxableIncome - 500000); 
            } else {
                taxAmount = 0.05 * 250000 + 0.1 * 250000 + 0.2 * 500000 + 0.2 * (taxableIncome - 1000000); 
            }
        }

        taxDeductionDTO.setTaxAmount(taxAmount);

        // Calculate cess
        double cessAmount = 0.0;
        if (taxDeductionDTO.getYearlySalary() > 2500000) {
            cessAmount = 0.02 * (taxDeductionDTO.getYearlySalary() - 2500000);
        }
        taxDeductionDTO.setCessAmount(cessAmount);

        return taxDeductionDTO;
    }

    private double calculateYearlySalary(TaxDeductionDTO employeeDTO) {
        // Considering monthly salary
        int monthsWorked = calculateMonthsWorked(employeeDTO.getDoj());
        double totalSalary = employeeDTO.getYearlySalary() * monthsWorked;
        return totalSalary;
    }

	private int calculateMonthsWorked(String doj) {
		// TODO Auto-generated method stub
		return 0;
	}

	private <R> R calculateTaxDeductionForEmployee(EmployeeDetailsDto employeedetailsdto1) {
		return (R) employeedetailsdto1.getSalary();
	}

	private <R> R calculateTaxDeductionForEmployee1(EmployeeDetailsDto employeedetailsdto1) {
		return (R) employeedetailsdto1.getSalary();
	}



}
