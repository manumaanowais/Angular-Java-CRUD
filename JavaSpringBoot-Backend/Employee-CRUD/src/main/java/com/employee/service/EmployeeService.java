package com.employee.service;

import java.util.List;

import com.employee.model.Employee;

public interface EmployeeService {

	public Employee createEmployee(Employee emp);
	
	public List<Employee> getEmployees();
	
	public Employee getEmployeeById(Long id);
	
	public void updateEmployee(Long id,Employee emp);
	
	public void deleteEmployee(Long id);
}
