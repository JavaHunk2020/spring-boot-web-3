package com.it;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	
	@GetMapping("/greet")
	public String showPage() {
		return "jadoo/welcome"; //  /welcome.jsp
	}
	

	@GetMapping("/auth")
	public String showLoginPage() {
		return "jadoo/login"; //  /welcome.jsp
	}


}
