package com.spring.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spring.demo.bean.UserBean;

@RestController
public class RestTemplateTest {

	@RequestMapping("/xml")
	public String getXMLResponse() {
		String cinemaURL = "http://planetakino.ua/lvov2/showtimes/xml/";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(cinemaURL, String.class);
		System.out.println(result);
		return result;
	}
	
	@RequestMapping("/json")
	public String getJSONResponse() {
		String jsonURL = "http://query.yahooapis.com/v1/public/yql?q=select%20%2a%20from%20yahoo.finance.quotes%20WHERE%20symbol%3D%27WRC%27&format=json&diagnostics=true&env=store://datatables.org/alltableswithkeys&callback";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(jsonURL, String.class);
		System.out.println(result);
		return result;
	}
	
	@RequestMapping("/userdata")
	public UserBean getUSERResponse() {
		String userURL = "http://localhost:8081/user/jdbc/{login}";
		
		Map<String, String> params = new HashMap<String, String>();
	    params.put("login", "admin");
		
		RestTemplate restTemplate = new RestTemplate();
		UserBean user = restTemplate.getForObject(userURL, UserBean.class, params);
		
		return user;
	}

}
