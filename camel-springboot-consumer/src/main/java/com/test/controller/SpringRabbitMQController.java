package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.Employee;
import com.test.services.EmployeeService;

@RestController
public class SpringRabbitMQController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employee/{empId}")
	Employee getEmployeeById(@PathVariable("empId") String empId) {
		Employee employee = new Employee();
		employee.setEmpId(new Integer(empId));
		employee = employeeService.getEmployeeById(employee);
		return employee;
	}
}