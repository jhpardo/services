package com.rustico.ramona.Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ServiceApplication {

	@Bean
    public RestTemplate getresttemplate() {
        return new RestTemplate();
    }
	
	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}

}