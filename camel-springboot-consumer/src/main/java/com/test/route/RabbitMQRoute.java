package com.test.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.model.Employee;
import com.test.processors.EmployeeProcessor;;

@Component
public class RabbitMQRoute extends RouteBuilder {

	@Autowired
	private EmployeeProcessor employeeProcessor;

	@Override
	public void configure() throws Exception {

		JacksonDataFormat jsonDataFormat = new JacksonDataFormat(Employee.class);

		from("rabbitmq://localhost:5672/TEST-QUEUE.exchange?queue=Checkin.queue&autoDelete=false")
		.routeId("rabbitMQRoute")
		.unmarshal(jsonDataFormat)
		.process(employeeProcessor)
		//.to("stream:out")
		.end();
	}
}