package com.example.apiversioning;

import com.example.apiversioning.infrastructure.persistence.CustomerRepository;
import org.springframework.context.annotation.Bean;

public class AppConfig {

    @Bean
    public CustomerRepository customerRepository(){
        return new CustomerRepository();
    }
}
