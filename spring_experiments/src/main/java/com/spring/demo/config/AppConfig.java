package com.spring.demo.config;

import com.spring.demo.component.Test;

//@Configuration
public class AppConfig {
	
	//@Bean
	public Test test() {
		return new Test();
	}
	
}
