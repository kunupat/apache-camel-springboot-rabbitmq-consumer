package com.test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.data.repositories.EmployeeRepository;
import com.test.model.Employee;

@Component
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee getEmployeeById(Employee employee) {
		return (Employee)employeeRepository.findByEmpId(employee.getEmpId());
	}
}
