package com.it.controller;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.it.repository.Signup;
import com.it.repository.SignupRespository;

@Controller
public class SignupController {
	
	
	@Autowired
	private SignupRespository signupRespository;
	

	@GetMapping({"/signup","/","aha"})
	public String showLoginPage() {
		return "signup"; //  /welcome.jsp
	}
	
	//<form action="auth" method="post">
	@PostMapping("/signup")
	public String postSigup(@ModelAttribute Signup signup, Model model) {
		
		/*
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String email=req.getParameter("email");
		String gender=req.getParameter("gender");
		Signup signup=new Signup();
		signup.setEmail(email);
		signup.setGender(gender);
		signup.setPassword(password);
		signup.setUsername(username);*/
		
		signup.setTimestamp(new Date());
		signupRespository.save(signup);
		model.addAttribute("message","You have done signup successfully!");
		return "jadoo/login"; //  /welcome.jsp
	}

}
