package com.auth.endpoint;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.entity.User;
import com.auth.repository.UserRepository;


@RestController
public class Resource {
	
	@Autowired
	UserRepository userRepository;
	
	
	@GetMapping("/getCurrentUser")
	public Principal getCurrentUser(Principal principal) {
		return principal;
	}
	
	@GetMapping("/allUsers")
	public List<User> getAllUsers(){
		return userRepository
				.findAll();
	}
}
