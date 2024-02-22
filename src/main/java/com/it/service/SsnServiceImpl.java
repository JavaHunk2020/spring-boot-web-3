package com.it.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.it.controller.dto.SsnDTO;
import com.it.repository.SsnRepository;
import com.it.repository.entity.SsnEntity;

@Service
public class SsnServiceImpl implements SsnService{
	
	@Autowired
	private SsnRepository ssnRepository;
	
	@Override
	public List<SsnDTO> findAll(){
		List<SsnEntity> entityList =ssnRepository.findAll();
		List<SsnDTO> ssnDTOs=new ArrayList<SsnDTO>();
		//Write logic to convert List<SsnEntity> into List<SsnDTO>
		for(SsnEntity entity : entityList) {
			SsnDTO dto=new SsnDTO();
			//Copying whole object data
			BeanUtils.copyProperties(entity, dto);
			ssnDTOs.add(dto);
		}
		return ssnDTOs;
	}
	
	@Override
	public void save(SsnDTO ssnDTO) {
		SsnEntity entity =new SsnEntity();
		BeanUtils.copyProperties(ssnDTO, entity);
		ssnRepository.save(entity);
	}
	
	@Override
	public SsnDTO findBySSN(String ssn) {
		Optional<SsnEntity> optional=ssnRepository.findBySsn(ssn);
		SsnDTO dto=new SsnDTO();
		if(optional.isEmpty()) {
		  throw new EmptyResultDataAccessException("SSN does not exist into the database.",0);			
		}
		BeanUtils.copyProperties(optional.get(), dto);
		return dto;
	}

}
