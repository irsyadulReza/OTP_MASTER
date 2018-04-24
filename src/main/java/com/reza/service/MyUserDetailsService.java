package com.reza.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.reza.model.User;
import com.reza.repo.UserRepository;



@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
    private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username);
		
		GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
		UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(user.getUsername(),
				user.getPassword(), Arrays.asList(authority));
		
		return userDetails;
	}

}
