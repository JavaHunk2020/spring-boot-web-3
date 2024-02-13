package com.it.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.repository.Signup;
import com.it.repository.SignupRespository;

@Service
public class AuthService {
	
	@Autowired
	private SignupRespository signupRespository;

	public boolean validateUser(String username, String password) {
		Optional<Signup> optional=signupRespository.findByUsernameAndPassword(username, password);
		return optional.isPresent();
	}

}
