package com.employee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;

@Controller
@CrossOrigin(origins = "*")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/employees")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {
		employeeService.createEmployee(emp);
		return ResponseEntity.ok(emp); 
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees(){
		return ResponseEntity.ok(employeeService.getEmployees()) ;
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee emp) {
		Employee updatedEmployee = employeeService.getEmployeeById(id);
		updatedEmployee.setFirstName(emp.getFirstName());
		updatedEmployee.setLastName(emp.getLastName());
		updatedEmployee.setEmail(emp.getEmail());
		updatedEmployee.setDob(emp.getDob());
		updatedEmployee.setGender(emp.getGender());
		updatedEmployee.setEducation(emp.getEducation());
		updatedEmployee.setCompany(emp.getCompany());
		updatedEmployee.setExperience(emp.getExperience());
		updatedEmployee.setPackages(emp.getPackages());
		employeeService.updateEmployee(id, updatedEmployee);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		employeeService.deleteEmployee(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
