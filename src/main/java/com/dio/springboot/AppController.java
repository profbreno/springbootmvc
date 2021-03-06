package com.dio.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@Value("${app.message}")
	private String appMessage;
	
	@Value("${ENV_DB_URL:NENHUMA}")
	private String dbEnvVariable;
	
	@GetMapping("/")
	public String getAppMessage() {
		return appMessage;
	}
	
	@GetMapping("/envVariable")
	public String getDbEnvVariable() {
		return "A seguinte variável de ambiente foi passada: " 
					+ dbEnvVariable;
	}
	
}
