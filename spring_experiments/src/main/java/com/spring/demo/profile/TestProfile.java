package com.spring.demo.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class TestProfile {
	
	@Bean
	@Profile("dev")
	public String profileDev() {
		System.out.println("set up dev prifle");
		return "";
	}
	
	@Bean
	@Profile("test")
	public String profileTest() {
		System.out.println("set up test prifle");
		return "";
	}
	
}
