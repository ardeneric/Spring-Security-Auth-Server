package com.notewitch.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
//@Order(1)
public class UserWebSecurityConfig{
	/*@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
				.and()
				.csrf().disable()
				.authorizeRequests()
				.antMatchers("/addUser", "/signup")
				.permitAll()
				.and()
				.formLogin().loginPage("/login").permitAll();
	}*/
}
