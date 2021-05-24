package com.baeldung.springservicevalidation.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baeldung.springservicevalidation.dao.UserAccountDao;
import com.baeldung.springservicevalidation.domain.UserAccount;

@Service
public class UserAccountService {

	@Autowired
	private Validator validator;
	
	@Autowired
	private UserAccountDao dao;
	
	public static final String SINGLE_SPACE = " "; 

	public String addUserAccount(UserAccount useraccount) {
		
		Set<ConstraintViolation<UserAccount>> violations = validator.validate(useraccount);

		if (!violations.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			for (ConstraintViolation<UserAccount> constraintViolation : violations) {
				sb.append(constraintViolation.getMessage()).append(SINGLE_SPACE);
			}

			dao.addUserAccount(useraccount);
			
			throw new ConstraintViolationException("Error occurred: " + sb.toString(), violations);
		}
		
		

		return "Account for " + useraccount.getName() + " Added!";
	}

}
