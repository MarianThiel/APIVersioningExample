package com.example.apiversioning.core.service;

import com.example.apiversioning.core.entities.Customer;
import com.example.apiversioning.core.usecase.CreateCustomerUseCase;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateCustomerService implements CreateCustomerUseCase {

    @Override
    public Mono<Void> createCustomer(Customer customer) {
        return null;
    }
}
