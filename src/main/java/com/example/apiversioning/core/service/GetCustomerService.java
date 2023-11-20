package com.example.apiversioning.core.service;

import com.example.apiversioning.core.entities.Customer;
import com.example.apiversioning.core.entities.CustomerId;
import com.example.apiversioning.core.ports.GetCustomerPort;
import com.example.apiversioning.core.usecase.GetCustomerUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@AllArgsConstructor
public class GetCustomerService implements GetCustomerUseCase {


    private GetCustomerPort getCustomerPort;

    @Override
    public Mono<List<Customer>> getAllCustomers() {
        return getCustomerPort.getAllCustomers();
    }

    @Override
    public Mono<Customer> getCustomerById(CustomerId customerId) {
        return getCustomerPort.getCustomerById(customerId)
                .switchIfEmpty(Mono.error(new CustomerNotFoundException()));
    }

    @Override
    public Mono<Customer> getCustomerByEmail(String email) {
        return getCustomerPort.getCustomerByEmail(email)
                .switchIfEmpty(Mono.error(new CustomerNotFoundException()));
    }
}
