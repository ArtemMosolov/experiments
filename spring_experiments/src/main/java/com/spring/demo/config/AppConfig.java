package com.spring.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.demo.Test;

//@Configuration
public class AppConfig {
	
	//@Bean
	public Test test() {
		return new Test();
	}
	
}
