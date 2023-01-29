package com.br;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EntityScan(basePackages = {"com.br.domain"})
//@EnableJpaRepositories(basePackages = "com.br.repository")
public class TestApiApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TestApiApplication.class, args);
	}
	

}
