package com.example.apiversioning;

import com.example.apiversioning.api.common.DTOConversionService;
import com.example.apiversioning.api.customer.dto.CustomerDto;
import com.example.apiversioning.api.customer.dto.versioning.CustomerDtoV2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiversioningApplication {

	public static void main(String[] args) {

		SpringApplication.run(ApiversioningApplication.class, args);
	}

}
