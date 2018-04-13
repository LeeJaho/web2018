package com.notepubs.web.config;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class NotepubsDispatcherServletInitializer 
			extends AbstractAnnotationConfigDispatcherServletInitializer{

	//기본적인 MVC 외의 것들 모아두기
	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class[] {
				NotepubsSecurityConfig.class
		};
		
	}

	//servlet 관련된 것 넣어놓기
	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] {
			ServletContextConfig.class,
			NotepubsMvcConfigurer.class,
			HibernateConfig.class,
			TilesConfig.class
			
			};
		}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}
	
	private Filter characterEncodingFilter() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		
		return filter;
	}
	
	@Override
	protected Filter[] getServletFilters() {
		// TODO Auto-generated method stub
		return new Filter[] {
				characterEncodingFilter()
				
		};
	}



}