package com.dio.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties("spring.data.mongodb")
@Getter
@Setter
public class DBConfiguration {
	
	private String uri;
	private String database;
	
	@Profile("dev")
	@Bean
	public String testDatabaseConnection() {
		System.out.println("DB connection for DEV - H2");
		System.out.println(uri);
		System.out.println(database);
		return "DB Connection to H2_TEST - Test instance";
	}

	@Profile("prod")
	@Bean
	public String productionDatabaseConnection() {
		System.out.println("DB connection for Production - Mongo");
		//System.out.println(uri);
		//System.out.println(database);
		return "DB Connection to MONGO_PROD - Production instance";
	}
	
}
