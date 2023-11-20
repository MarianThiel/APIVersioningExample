package com.example.apiversioning.core.ports;

import com.example.apiversioning.core.entities.Customer;
import com.example.apiversioning.core.entities.CustomerId;
import reactor.core.publisher.Mono;

import java.util.List;

public interface GetCustomerPort {
    Mono<List<Customer>> getAllCustomers();
    Mono<Customer> getCustomerByEmail(String email);

    Mono<Customer> getCustomerById(CustomerId customerId);

}
