package com.wglabs.petstore.spring.config;

import java.util.Properties;

import javax.persistence.spi.PersistenceProvider;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
@EnableJpaRepositories(basePackages = { "com.wglabs.petstore.repository" })
public class PersistenceConfiguration {

	
	@Value("${hibernate.dialect}")
	private String hibernateDialect;
	
	@Value("${ejb.naming.strategy}")
	private String ejbNamingStrategy;
	
	@Value("${entitymanager.packages.to.scan}")
	private String entityManagerPackagesToScan;

	@Value("${hibernate.format_sql}")
	private String hibernateFormatSqlStatements;

	@Value("${hibernate.show_sql}")
	private String hibernateShowSqlStatements;

	@Autowired
	private DataSource datasource;

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public JpaTransactionManager transactionManager() throws ClassNotFoundException {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		HibernateJpaDialect jpaDialect = new HibernateJpaDialect();
		transactionManager.setJpaDialect(jpaDialect);

		return transactionManager;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws ClassNotFoundException {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(datasource);
		entityManagerFactoryBean.setPackagesToScan(entityManagerPackagesToScan);
		entityManagerFactoryBean.setPersistenceProviderClass(getPersistanceProvider());
		entityManagerFactoryBean.setJpaProperties(entityManagerProperties());
		return entityManagerFactoryBean;
	}

	private Properties entityManagerProperties() {
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.dialect", hibernateDialect);
		jpaProperties.put("hibernate.format_sql", hibernateFormatSqlStatements);
		jpaProperties.put("hibernate.ejb.naming_strategy", ejbNamingStrategy);
		jpaProperties.put("hibernate.show_sql", hibernateShowSqlStatements);
		return jpaProperties;
	}

	@SuppressWarnings("unchecked")
	private <T extends PersistenceProvider> Class<T> getPersistanceProvider() throws ClassNotFoundException {
		return (Class<T>) Class.forName("org.hibernate.jpa.HibernatePersistenceProvider");
	}

	@Bean
	public TransactionTemplate transactionTemplate() throws ClassNotFoundException {
		return new TransactionTemplate(transactionManager());
	}
}
