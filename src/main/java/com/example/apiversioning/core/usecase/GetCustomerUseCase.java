package com.example.apiversioning.core.usecase;

import com.example.apiversioning.core.entities.Customer;
import com.example.apiversioning.core.entities.CustomerId;
import reactor.core.publisher.Mono;

import java.util.List;

public interface GetCustomerUseCase {

    Mono<List<Customer>> getAllCustomers();

    Mono<Customer> getCustomerById(CustomerId customerId);

    Mono<Customer> getCustomerByEmail(String email);
}
