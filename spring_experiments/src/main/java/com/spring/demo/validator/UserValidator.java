package com.spring.demo.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.spring.demo.bean.UserBean;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserBean.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "login", "login.empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "password.empty");
		UserBean user = (UserBean) target;
		
		if(user.getLogin() == null) {
			errors.rejectValue("login", "login can be null");
		} else if(user.getPassword() == null) {
			errors.rejectValue("password", "password can be null");
		}
		
	}

}
