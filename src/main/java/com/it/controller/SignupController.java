package com.it.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.it.service.AuthService;

@Controller
public class SignupController {
	
	
	@Autowired
	private AuthService authService;
	

	@GetMapping("/signup")
	public String showLoginPage() {
		return "signup"; //  /welcome.jsp
	}
	
	//<form action="auth" method="post">
	@PostMapping("/signup")
	public String postSigup(HttpServletRequest req) {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String email=req.getParameter("email");
		String gender=req.getParameter("gender");
		System.out.println("username = "+username);
		System.out.println("password = "+password);
		System.out.println("email = "+email);
		System.out.println("gender = "+gender);
		req.setAttribute("message","You have done signup successfully!");
		return "jadoo/login"; //  /welcome.jsp
	}

}
