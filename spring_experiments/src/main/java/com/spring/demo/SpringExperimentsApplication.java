package com.spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

//@EnableAutoConfiguration
//@ComponentScan("com.spring.demo")

//@ImportResource("classpath:config.xml")   needed to load xml file with declared beans ...

@SpringBootApplication
public class SpringExperimentsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext cax = SpringApplication.run(SpringExperimentsApplication.class, args);
	}
}
