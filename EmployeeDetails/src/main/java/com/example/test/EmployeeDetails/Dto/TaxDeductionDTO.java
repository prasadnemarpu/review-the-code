package com.example.test.EmployeeDetails.Dto;

public class TaxDeductionDTO {

	private String employeeCode;
    private String firstName;
    private String lastName;
    private Double yearlySalary;
    private Double taxAmount;
    private Double cessAmount;
    private String Doj;
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Double getYearlySalary() {
		return yearlySalary;
	}
	public void setYearlySalary(Double yearlySalary) {
		this.yearlySalary = yearlySalary;
	}
	public Double getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}
	public Double getCessAmount() {
		return cessAmount;
	}
	public void setCessAmount(Double cessAmount) {
		this.cessAmount = cessAmount;
	}
	public TaxDeductionDTO(String employeeCode, String firstName, String lastName, Double yearlySalary,
			Double taxAmount, Double cessAmount,String Doj) {
		super();
		this.employeeCode = employeeCode;
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearlySalary = yearlySalary;
		this.taxAmount = taxAmount;
		this.cessAmount = cessAmount;
		this.Doj=Doj;
	}
	public TaxDeductionDTO() {
		// TODO Auto-generated constructor stub
	}
	public String getDoj() {
		return Doj;
	}
	public void setDoj(String doj) {
		Doj = doj;
	}
	
    
	
}
