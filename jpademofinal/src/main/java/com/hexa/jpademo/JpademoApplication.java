package com.hexa.jpademo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpademoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpademoApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}

}
