package com.notewitch.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavigationController {

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
