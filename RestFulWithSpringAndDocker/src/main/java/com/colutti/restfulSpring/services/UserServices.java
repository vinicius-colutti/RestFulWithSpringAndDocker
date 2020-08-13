package com.colutti.restfulSpring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.colutti.restfulSpring.data.model.User;
import com.colutti.restfulSpring.repository.UserRepository;

@Service
public class UserServices implements UserDetailsService {
	
	
	@Autowired
	UserRepository repository;

	public UserServices(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByUsername(username);
		if(user != null) {		
			return user;
		}else {
			throw new UsernameNotFoundException("Username "+ username + " not found");
		}
	}
	
	
}
