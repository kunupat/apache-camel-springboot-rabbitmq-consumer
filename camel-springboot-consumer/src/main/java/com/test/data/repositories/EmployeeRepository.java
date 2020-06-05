package com.test.data.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.model.Employee;

public interface EmployeeRepository  extends MongoRepository<Employee, String> {
	public Employee findByEmpId(Integer empId);
	public List<Employee> findByName(String name);
}
