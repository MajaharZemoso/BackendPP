package com.majahar.pairprogramming;

import com.majahar.pairprogramming.mapper.BookMapper;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PairprogrammingApplication {

	public static void main(String[] args) {
		SpringApplication.run(PairprogrammingApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
	
	@Bean
	public BookMapper bookMapper(){
		return new BookMapper();
	}

}
