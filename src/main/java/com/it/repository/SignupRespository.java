package com.it.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SignupRespository extends JpaRepository<Signup, String> {
	
	public Optional<Signup> findByUsernameAndPassword(String username,String password);

}
