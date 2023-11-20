package com.example.apiversioning.core.ports;

import com.example.apiversioning.core.entities.Customer;
import reactor.core.publisher.Mono;

public interface CreateCustomerPort {

    Mono<Void> createCustomer(Customer customer);
}
