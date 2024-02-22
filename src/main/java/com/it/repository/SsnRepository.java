package com.it.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.it.repository.entity.SsnEntity;

@Repository
public interface SsnRepository extends JpaRepository<SsnEntity, Integer>{
	
	public Optional<SsnEntity> findBySsn(String ssn);

}
