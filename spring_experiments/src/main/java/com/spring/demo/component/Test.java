package com.spring.demo.component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.spring.demo.bean.BeanInterface;

@Component
public class Test {
	
	@Autowired
	//@Qualifier(value="bean1")
	private BeanInterface beanInterface;
	
	public void xz() {
		System.out.println("xz 123");
	}
	
	@PostConstruct
	public void postConstruct () {
		System.out.println("PostConstruct");
	}
	
	@PreDestroy
	public void preDestroy () {
		System.out.println("PreDestroy");
	}
	
	
}
