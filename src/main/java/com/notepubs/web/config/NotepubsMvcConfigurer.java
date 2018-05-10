package com.notepubs.web.config;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
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
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry
		.addViewController("/")
		.setViewName("redirect:/index");
	}
	
	@Override
	   public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

	      final StringHttpMessageConverter stringHttpMessageConverter 
	      	= new StringHttpMessageConverter(Charset.forName("UTF-8"));
	      stringHttpMessageConverter.setWriteAcceptCharset(false);

	      converters.add(stringHttpMessageConverter);

	      WebMvcConfigurer.super.configureMessageConverters(converters);
	   }
}
