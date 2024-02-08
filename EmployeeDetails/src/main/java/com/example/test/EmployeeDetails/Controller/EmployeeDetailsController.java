package com.example.test.EmployeeDetails.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.EmployeeDetails.Dto.EmployeeDetailsDto;
import com.example.test.EmployeeDetails.Dto.TaxDeductionDTO;
import com.example.test.EmployeeDetails.Exception.EmployeeValidationException;
import com.example.test.EmployeeDetails.Service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeDetailsController {
	
	EmployeeService employeeService;
	
	@PostMapping("/add")
    public ResponseEntity<String> addEmployee(@RequestBody EmployeeDetailsDto employeeDTO) throws EmployeeValidationException {
        // Validate and add employee details
		employeeService.saveEmployee(employeeDTO);
		return new ResponseEntity<>("Employee added successfully", HttpStatus.OK);
    }

   
    
    @GetMapping("/tax-deduction")
    public ResponseEntity<List<TaxDeductionDTO>> getTaxDeduction() {
       
        List<TaxDeductionDTO> taxDeductions = employeeService.calculateTaxDeduction();
        return new ResponseEntity<>(taxDeductions, HttpStatus.OK);
    }
    
}
