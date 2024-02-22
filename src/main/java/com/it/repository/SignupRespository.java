package com.it.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.it.repository.entity.Signup;

public interface SignupRespository extends JpaRepository<Signup, String> {
	
	public Optional<Signup> findByUsernameAndPassword(String username,String password);
	
	@Query("Select c from Signup c where c.username LIKE  %?1% or c.email LIKE  %?2%")
	List<Signup> findByUsernameOrEmail(String username,String email);

}
	