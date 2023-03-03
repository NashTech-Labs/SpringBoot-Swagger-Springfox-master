package com.nashtech.springbootswaggerspringfox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringBootSwaggerSpringfoxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSwaggerSpringfoxApplication.class, args);
	}

}
