package com.notewitch.auth.endpoint;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notewitch.auth.entity.User;
import com.notewitch.auth.repository.UserRepository;


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
	
	@GetMapping("/exit")
    public void exit(HttpServletRequest request, HttpServletResponse response) {
        // token can be revoked here if needed
        new SecurityContextLogoutHandler().logout(request, null, null);
        try {
            //sending back to client app
            response.sendRedirect(request.getHeader("referer"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
