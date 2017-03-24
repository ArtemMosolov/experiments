package com.spring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.component.Test;

@RestController
public class HelloController {
	
	private static Test test;
	
	@Autowired
	public void setTest(Test test) {
		HelloController.test = test;
	}

	@RequestMapping("/hello")
	public String index() {
		test.xz();
		return "Greetings from Spring Boot!";
	}

}