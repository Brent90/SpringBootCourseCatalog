package com.slinger.SpringBootCourseCatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

@SpringBootApplication
public class SpringBootCourseCatalogApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringBootCourseCatalogApplication.class, args);
	}

}
