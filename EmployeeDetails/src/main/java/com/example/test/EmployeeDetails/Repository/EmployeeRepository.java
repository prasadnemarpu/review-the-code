package com.example.test.EmployeeDetails.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.test.EmployeeDetails.Dto.EmployeeDetailsDto;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDetailsDto, Integer> {

	List<EmployeeDetailsDto> getAllEmployees();
	

}
