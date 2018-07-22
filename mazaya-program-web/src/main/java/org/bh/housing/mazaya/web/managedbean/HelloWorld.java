package org.bh.housing.mazaya.web.managedbean;

import javax.inject.Named;

import org.bh.housing.mazaya.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Named
@Scope("view")
public class HelloWorld {

	@lombok.Getter
	@lombok.Setter
	private String firstName = "John";
	
	@lombok.Getter
	@lombok.Setter
	private String lastName = "Doe";
	
	@Autowired
	private RequestService service;

	public String showGreeting() {
		return "Hello " + firstName + " " + lastName + "!";
	}
}
