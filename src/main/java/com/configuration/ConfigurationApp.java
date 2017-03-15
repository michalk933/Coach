package com.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.incrementer.MySQLMaxValueIncrementer;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;



@Configuration
@ComponentScan({"com.rest","com.repository","com.service"})
@EnableWebMvc
public class ConfigurationApp {
	
	
	@Bean
	public ViewResolver viewResolver(){
		FreeMarkerViewResolver free = new FreeMarkerViewResolver();
		free.setPrefix("");
		free.setSuffix(".ftl");
		free.setContentType("text/html;charset=UTF-8");
		return free;
	}
	
	@Bean
	public FreeMarkerConfigurer freeMarkerConfigurer(){
		FreeMarkerConfigurer freeConf = new FreeMarkerConfigurer();
		freeConf.setTemplateLoaderPath("classpath:/WEB-INF/templates");
		return freeConf;
	}
	
	@Bean
	public MysqlDataSource dataSource(){
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setURL("jdbc:mysql://localhost:3306/findcoach?useSSL=false");
		dataSource.setUser("test");
		dataSource.setPassword("test");
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(){
		return new JdbcTemplate(dataSource());
	}
	
	
	

	

}
