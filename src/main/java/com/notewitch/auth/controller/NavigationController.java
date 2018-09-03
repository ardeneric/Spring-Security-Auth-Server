package com.notewitch.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.notewitch.auth.entity.Role;
import com.notewitch.auth.entity.User;
import com.notewitch.auth.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class NavigationController {
	@Autowired
	UserRepository userRepository;

	@RequestMapping("/login")
	public String login() {
		
		return "login";
	}

	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("user", new User());
		return "signup";
	}

	@PostMapping("/addUser")
	public String addUser(User user, Model model) {
		if (userRepository.findByUsername(user.getUsername()).isPresent()) {
			model.addAttribute("userPresent", true);
		}else {
			log.info("Saving new user ::" + user.getUsername() );
			Role r = new Role();
			r.setId(1);
			user.setRoleId(r);
			userRepository.save(user);
		}
		return "redirect:/login";
	}
}
