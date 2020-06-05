package com.test.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.data.repositories.EmployeeRepository;
import com.test.model.Employee;

@Component
public class EmployeeProcessor implements Processor {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public void process(Exchange exchange) throws Exception {
		
		Employee employee = (Employee) exchange.getIn().getBody();
	
		employeeRepository.save(employee);
		
		System.out.println("Saved:" + employee.getName());
		
	}
	
}
