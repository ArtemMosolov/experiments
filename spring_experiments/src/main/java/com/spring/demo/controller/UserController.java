package com.spring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.bean.UserBean;
import com.spring.demo.data.mongo.UserRepository;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@RequestMapping(value = "/{login}", method = RequestMethod.GET)
	public ResponseEntity<UserBean> getUserByLogin(@PathVariable String login) {
		ResponseEntity<UserBean> response;
		UserBean userBean = repository.getUserByLogin(login);
		response = new ResponseEntity<>(userBean, HttpStatus.OK);
		return response;
	}
	
}
