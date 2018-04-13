package com.notepubs.web.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement //annotaion으로 Transactional 하겠다
@ComponentScans(value={
		@ComponentScan("com.notepubs.web.dao.hb"),
		@ComponentScan("com.notepubs.web.service")
})
public class HibernateConfig {
	
	
	@Bean(destroyMethod="close")
	public ComboPooledDataSource dataSource() throws PropertyVetoException {
		
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://vaio.notepubs.com/notepubsdb?serverTimezone=UTC&amp;autoReconnect=true&amp;useSSL=false&amp;useUnicode=true&amp;characterEncoding=utf8");
		dataSource.setUser("notepubs");
		dataSource.setPassword("cclass");
		dataSource.setMinPoolSize(5); 
		dataSource.setMaxPoolSize(20);
		dataSource.setMaxIdleTime(3000);
		
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() throws PropertyVetoException{
		Properties pros = new Properties();
		pros.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		pros.put("hibernate.show_sql", "true");
		
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		//DI 하는 법
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.notepubs.web.entity");
		sessionFactory.setHibernateProperties(pros);
		
		return sessionFactory;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager() throws PropertyVetoException {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		
		//getObject -> 부모? 클래스로 뭐시기
		transactionManager.setSessionFactory(sessionFactory().getObject());
		
		return transactionManager;
		
	}
}
