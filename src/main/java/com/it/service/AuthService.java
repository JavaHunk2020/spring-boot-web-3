package com.it.service;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

	public boolean validateUser(String username, String password) {
		if ("jack".equalsIgnoreCase(username) && "jill".equalsIgnoreCase(password)) {
			return true;
		} else {
			return false;
		}
	}

}
