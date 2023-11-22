package com.example.apiversioning.infrastructure.persistence;

import com.example.apiversioning.core.entities.Address;
import com.example.apiversioning.core.entities.Customer;
import com.example.apiversioning.core.entities.CustomerId;
import com.example.apiversioning.core.ports.CreateCustomerPort;
import com.example.apiversioning.core.ports.GetCustomerPort;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerRepository implements CreateCustomerPort, GetCustomerPort {

    private final Map<CustomerId, Customer> customers = new HashMap<>();

    private static int currentCustomerId = 1;
    public CustomerRepository(){
        populate();
    }
    private static CustomerId getNewCustomerId(){
        return new CustomerId(currentCustomerId++);
    }
    private void addCustomer(Customer c){
        System.out.println(c + "Created");
        customers.put(getNewCustomerId(), c);
    }
    private void populate(){
        List<Customer> cl = List.of(new Customer[]{
                new Customer(
                        "Jon",
                        "Doe",
                        123,
                        "jon.doe@test.com",
                        new Address("TestCity","12345","Street 2a", "")
                ),
                new Customer(
                        "Eve",
                        "L",
                        1234,
                        "eve.l@test.com",
                        new Address("TestCity","","Street 2a", "")
                ),
                new Customer(
                        "Max",
                        "Mustermann",
                        123,
                        "max.mustermann@test.com",
                        new Address("TestCity","","Street 2a", "")
                ),
                new Customer(
                        "Chuck",
                        "Norris",
                        123,
                        "chuck.norris@test.com",
                        new Address("TestCity","", "Street 2a","")
                )
        });
        cl.forEach(this::addCustomer);
    }
    @Override
    public Mono<Void> createCustomer(Customer customer) {
        addCustomer(customer);
        return Mono.empty();
    }

    @Override
    public Mono<List<Customer>> getAllCustomers() {
        return Mono.just(customers.values().stream().toList());
    }

    @Override
    public Mono<Customer> getCustomerByEmail(String email) {

        return Mono.justOrEmpty(customers.values().stream()
                .filter(customer -> email.equals(customer.getEmail()))
                .findFirst());
    }

    @Override
    public Mono<Customer> getCustomerById(CustomerId customerId) {
        return Mono.justOrEmpty(customers.get(customerId));

    }
}
