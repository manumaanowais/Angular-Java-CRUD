package com.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.Employee;
import com.employee.repo.EmployeeRepository;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public void updateEmployee(Long id, Employee emp) {
		employeeRepository.save(emp);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).get();
	}

}
