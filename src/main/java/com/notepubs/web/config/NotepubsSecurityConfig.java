package com.notepubs.web.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages="com.notepubs.web.config")
public class NotepubsSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private AuthenticationSuccessHandler successHandler;
	
	/*@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}*/

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//인터셉트와 관련된 내용
		http
			.csrf().disable()
			.authorizeRequests()
			//-------------------------------------------
			/*.antMatchers("/*", "/note/**", "/member/**").anonymous()
			.antMatchers("/resources/**").permitAll()*/
			.antMatchers("/author/**").hasAnyRole("AUTHOR", "ADMIN")
			.antMatchers("/admin/**").hasRole("ADMIN")
			//-------------------------------------------
			//.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/member/login")
			.successHandler(successHandler)
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
		
		/*auth.inMemoryAuthentication()
			.withUser(users.username("jaho").password("{noop}111").roles("AUTHOR"))
			.withUser(users.username("jungsoo").password("{noop}122").roles("AUTHOR"));*/
		
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select id, pwd password, 1 enabled from Member where id=?")
        .authoritiesByUsernameQuery("select memberId id, roleId authority from MemberRole where memberId=?")
        .passwordEncoder(new BCryptPasswordEncoder());
	}
	
}
