package com.it.controller;


import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.it.repository.SignupRespository;
import com.it.repository.entity.Signup;

@Controller
public class SignupController {
	
	
	@Autowired
	private SignupRespository signupRespository;
	
	//deleteSignup? upname=hack1239		
    @GetMapping("/deleteSignup")
	public String deleteSignupMethod(@RequestParam String upname,Model model) {
    	signupRespository.deleteById(upname);
    	//Fetch remaining data from data
    	List<Signup> signups=signupRespository.findAll();
    	model.addAttribute("signups", signups);
		//Fetch data from data
		return "home";
	}
    
    @GetMapping("/editSignup")
  	public String editSignupData(@RequestParam String upname,Model model) {
      	Optional<Signup> optional=signupRespository.findById(upname);
      	model.addAttribute("dsignup", optional.get());
  		//Fetch data from data
  		return "esignup";
  	}
    
    
	@GetMapping("/searchSignup")
	public String searchtSignupData(@RequestParam String searchText, Model model) {
		List<Signup> signups = signupRespository.findByUsernameOrEmail(searchText,searchText);
		model.addAttribute("signups", signups);
		// Fetch data from data
		return "home";
	}
	
    /*@GetMapping("/sortByEmail")
	public String sortByEmailAndShow(@RequestParam String sort, Model model) {
    	List<Signup> signups=signupRespository.findAll();
    	if("asc".equalsIgnoreCase(sort)) {
    		Collections.sort(signups , (o1,o2)->o1.getEmail().compareTo(o2.getEmail()));
    	}else {
    		Collections.sort(signups , (o1,o2)->o2.getEmail().compareTo(o1.getEmail()));
    	}
    	model.addAttribute("signups", signups);
		//Fetch data from data
		return "home";
	}*/
    
    @GetMapping("/sortByEmail")
	public String sortByEmailAndShow(@RequestParam String sort, Model model) {
    	List<Signup> signups=signupRespository.findAll();
    	if("asc".equalsIgnoreCase(sort)) {
    		Collections.sort(signups , new Comparator<Signup>() {
				@Override
				public int compare(Signup o1, Signup o2) {
					return o1.getEmail().compareTo(o2.getEmail());
				}
			});
    	}else {
    		Collections.sort(signups , new Comparator<Signup>() {
				@Override
				public int compare(Signup o1, Signup o2) {
					return o2.getEmail().compareTo(o2.getEmail());
				}
			});
    	}
    	model.addAttribute("signups", signups);
		//Fetch data from data
		return "home";
	}
			
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
		Optional<Signup> optional=signupRespository.findById(signup.getUsername());
		if(optional.isPresent()) {
			model.addAttribute("message","Username aleady exists in system!");
			return "signup";
		}else {
			signupRespository.save(signup);
			model.addAttribute("message","You have done signup successfully!");
		}
		return "jadoo/login"; //  /welcome.jsp
	}
	
	@PostMapping("/usignup")
	public String upostSigup(@ModelAttribute Signup signup, Model model) {
		
		Signup dbsignup=signupRespository.findById(signup.getUsername()).get();
		dbsignup.setEmail(signup.getEmail());
		dbsignup.setGender(signup.getGender());
		dbsignup.setPassword(signup.getPassword());
		signupRespository.save(dbsignup);
		model.addAttribute("message","You have updated signup successfully!");
		//Fetch remaining data from data
    	List<Signup> signups=signupRespository.findAll();
    	model.addAttribute("signups", signups);
		//Fetch data from data
		return "home";
	}

}
