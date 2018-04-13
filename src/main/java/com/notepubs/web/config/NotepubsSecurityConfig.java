package com.notepubs.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

@Configuration
@EnableWebSecurity
public class NotepubsSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//인터셉트와 관련된 내용
		http
			.csrf().disable()
			.authorizeRequests()
			//-------------------------------------------
			/*.antMatchers("/*", "/note/**", "/member/**").anonymous()
			.antMatchers("/resources/**").permitAll()*/
			.antMatchers("/author/**").hasRole("AUTHOR")
			//-------------------------------------------
			//.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/member/login")
			//.loginProcessingUrl("/login")
			.loginProcessingUrl("/member/login")
			.permitAll()
			.and()
		.logout()
			//.logoutUrl("member/logout")
			.logoutSuccessUrl("/index")
			.invalidateHttpSession(true);
			
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//UserBuilder users = User.withDefaultPasswordEncoder();
		UserBuilder users = User.builder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("jaho").password("{noop}111").roles("AUTHOR"))
			.withUser(users.username("jungsoo").password("{noop}122").roles("AUTHOR"));
	}
	
}
