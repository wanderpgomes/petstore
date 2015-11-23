package com.wglabs.petstore.spring.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class DataSourceConfiguration {
	
	@Value("jdbc:mysql://${db.host}:${db.port}/${db.name}")
	private String dbUrl;

	@Value("${db.username}")
	private String dbUser;

	@Value("${db.password}")
	private String password;

	@Bean
	public DataSource dataSource() {
		return DataSourceBuilder.create()
				.driverClassName("com.mysql.jdbc.Driver")
				.url(dbUrl)
				.username(dbUser)
				.password(password)
				.build();
	}

	
}
