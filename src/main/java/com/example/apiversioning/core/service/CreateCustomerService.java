package com.example.apiversioning.core.service;

import com.example.apiversioning.core.entities.Customer;
import com.example.apiversioning.core.ports.CreateCustomerPort;
import com.example.apiversioning.core.usecase.CreateCustomerUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CreateCustomerService implements CreateCustomerUseCase {

    private CreateCustomerPort createCustomerPort;
    @Override
    public Mono<Void> createCustomer(Customer customer) {
        return createCustomerPort.createCustomer(customer);
    }
}
