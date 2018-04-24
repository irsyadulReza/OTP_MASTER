package com.reza.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reza.model.User;



public interface UserRepository extends JpaRepository<User, Long>{
	
	 User findByUsername(String username);

}
