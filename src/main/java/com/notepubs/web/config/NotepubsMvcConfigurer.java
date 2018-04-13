package com.notepubs.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc//
public class NotepubsMvcConfigurer implements WebMvcConfigurer{
	//Override를 강제로 하지 않아도 되게 했음 -> WebMvc 기능 골라쓰기
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry
		.addResourceHandler("/resources/**")
		.addResourceLocations("/resources/");
		
		
	}
}
