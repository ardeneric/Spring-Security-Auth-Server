package com.notewitch.auth.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.cors.CorsConfiguration;


@Configuration
@EnableResourceServer
public class ResourceServerConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
    private UserDetailsService userDetailsService;
	
	@Override
	public void configure(WebSecurity web) throws Exception{
		web
		.ignoring()
		.antMatchers("/css/**", "/fonts/**", "/img/**", "/js/**", "/sass/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
				.and()
				.csrf().disable()
				.requestMatchers()
				.antMatchers("/login","/oauth/authorize")
				.and()
				.authorizeRequests()
				.anyRequest()
				.authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.permitAll();
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth
			.parentAuthenticationManager(authenticationManager)
			.userDetailsService(userDetailsService);
	}

}
