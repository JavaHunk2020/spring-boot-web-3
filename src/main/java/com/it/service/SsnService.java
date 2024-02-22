package com.it.service;

import java.util.List;

import com.it.controller.dto.SsnDTO;

public interface SsnService {

	List<SsnDTO> findAll();

	void save(SsnDTO ssnDTO);

	SsnDTO findBySSN(String ssn);

}
