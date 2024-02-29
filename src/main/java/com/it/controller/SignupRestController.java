package com.it.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it.repository.SignupRespository;
import com.it.repository.entity.Signup;
import com.it.spring.security.JwtUtils;

@RestController
@RequestMapping("/api")
public class SignupRestController {
	
	@Autowired
	private SignupRespository signupRespository;

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@PostMapping("/cauth")
	public Map<String,Object>  postLogin(@RequestBody SignupDTO signupRequest) {
		//authentication has two things - username and role
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(signupRequest.getEmail(), signupRequest.getPassword()));
		//it will come here only when username and password are correct!!
		String jwt = jwtUtils.generateJwtToken(authentication);
		Map<String,Object> jwtReponse = new HashMap<>();
		jwtReponse.put("Authorization", jwt);
		jwtReponse.put("email", signupRequest.getEmail());
		jwtReponse.put("title", "Manager");
		return jwtReponse;
	}
	
	
//	/http://localhost:8080/api/signups/jack500
//	/http://localhost:8080/api/signups/admin12
	@DeleteMapping("/signups/{username}")
	@PreAuthorize("hasAuthority('ADMIN')")
	//@PathVariable it is used to read data from URI
	public MessageDTO deleteSignups(@PathVariable String username) {
		signupRespository.deleteById(username);
		MessageDTO messageDTO=new MessageDTO();
		messageDTO.setMessage("Resource is deleted successfully!");
		messageDTO.setCode(917827);
		return messageDTO;
	}
	
	//Http
    @GetMapping("/signups")
	public List<Signup> showSignups() {
    	List<Signup> signups=signupRespository.findAll();
		return signups;
	}
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/signups")
	public MessageDTO postSigup(@RequestBody Signup signup) {
		signup.setTimestamp(new Date());
		Optional<Signup> optional=signupRespository.findById(signup.getUsername());
		MessageDTO messageDTO=new MessageDTO();
		if(optional.isPresent()) {
			messageDTO.setMessage("Username aleady exists in system!");
			messageDTO.setCode(233);
		}else {
			signup.setPassword(passwordEncoder.encode(signup.getPassword()));
			signupRespository.save(signup);
			messageDTO.setMessage("You have done signup successfully!");
			messageDTO.setCode(200);
		}
		
		return messageDTO;
    }	
}
