package com.deniz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;



@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		 UserBuilder users=User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication()
		.withUser(users.username("cemil").password("123").roles("EMPLOYEE"))
		.withUser(users.username("rabia").password("test").roles("EMPLOYEE","MANAGER"))
		.withUser(users.username("deniz").password("12").roles("EMPLOYEE","ADMIN"));
		

		
	} 
	 

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
	//	http.authorizeRequests().anyRequest().authenticated(); Tüm kullanýcýlar tüm sayfalara eriþiyor.
		
		http.authorizeRequests()
		.antMatchers("/").authenticated()
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/employee/**").hasRole("EMPLOYEE");
		
		
		
		http.formLogin()
		.loginPage("/showMyLoginPage")
		.loginProcessingUrl("/authenticateTheUser")
		.permitAll()
		.and()
		.logout()
		.permitAll();
		
		http.exceptionHandling().accessDeniedPage("/access-denied");
	}

	
	
	

}
