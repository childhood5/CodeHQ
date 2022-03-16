package com.codeHQ.springbootapplication.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.codeHQ.springbootapplication.model.Employee;

@Component
public class RabbitMQConsumer {

	@RabbitListener(queues = "")
	public void recievedMessage(String employee) {
		System.out.println("Recieved Message From RabbitMQ: " + employee);
	}
	
}