package com.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	private static Test test;
	
	@Autowired
	public void setTest(Test test) {
		HelloController.test = test;
	}

	@RequestMapping("/")
	public String index() {
		test.xz();
		return "Greetings from Spring Boot!";
	}

}