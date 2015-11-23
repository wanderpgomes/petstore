package com.wglabs.petstore.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wglabs.petstore.service.IPetStoreService;
import com.wglabs.petstore.service.PetStoreService;

@Configuration
public class ServicesConfiguration {

	@Bean
	public IPetStoreService petStoreService(){
		return new PetStoreService();
	}
}
