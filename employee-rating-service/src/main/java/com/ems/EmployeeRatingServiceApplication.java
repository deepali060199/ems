package com.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "*")
public class EmployeeRatingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeRatingServiceApplication.class, args);
	}

}
