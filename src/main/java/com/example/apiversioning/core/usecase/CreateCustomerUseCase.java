package com.example.apiversioning.core.usecase;

import com.example.apiversioning.core.entities.Customer;
import reactor.core.publisher.Mono;

public interface CreateCustomerUseCase {
    Mono<Void> createCustomer(Customer customer);
}
