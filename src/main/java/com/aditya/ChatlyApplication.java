package com.aditya;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication(scanBasePackages = "com.aditya")
public class ChatlyApplication {
	public static void main(String[] args) {
		SpringApplication.run(ChatlyApplication.class, args);
		System.out.println("Chat Application Started");
	}
	  @Bean
	    public ModelMapper modelMapper() {
	        return new ModelMapper();
	    }

}
