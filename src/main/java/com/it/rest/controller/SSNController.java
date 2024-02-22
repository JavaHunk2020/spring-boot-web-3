package com.it.rest.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it.controller.dto.SsnDTO;
import com.it.service.SsnService;

@RestController
@RequestMapping("/v2")
public class SSNController {
	
	@Autowired
	private SsnService ssnService;
	
	@PostMapping("/ssns")
	public Map<String,Object> createSsn(@RequestBody SsnDTO ssnDTO){
		 
		 ssnDTO.setDoe(new Timestamp(new Date().getTime()));
		 
		 ssnService.save(ssnDTO);
		 return Map.of("code",200,"message","Ssn record is created successfully");
	}
	
	@GetMapping("/ssns")
	public List<SsnDTO> getAllSsn(){
		return ssnService.findAll();
	}
	
	@GetMapping("/ssns/{ssn}")
	public SsnDTO getSsnBySsn(@PathVariable String ssn){
		return ssnService.findBySSN(ssn);
	}

}
