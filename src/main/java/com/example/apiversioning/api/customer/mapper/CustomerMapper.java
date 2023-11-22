package com.example.apiversioning.api.customer.mapper;

import com.example.apiversioning.api.customer.dto.AddressDto;
import com.example.apiversioning.api.customer.dto.CustomerDto;
import com.example.apiversioning.core.entities.Address;
import com.example.apiversioning.core.entities.Customer;

public class CustomerMapper {

    public static Customer toDomain(CustomerDto customerDto){
        return new Customer(
                customerDto.getFirstName(),
                customerDto.getLastName(),
                customerDto.getPhoneNumber(),
                customerDto.getEmail(),
                new Address(
                        customerDto.getAddress().getCity(),
                        customerDto.getAddress().getPostalCode(),
                        customerDto.getAddress().getAddressLine(),
                        customerDto.getAddress().getAddressLine2()
                )

        );
    }

    public static CustomerDto fromDomain(Customer customer){
        return new CustomerDto(
                customer.getFirstName(),
                customer.getLastName(),
                customer.getPhoneNumber(),
                customer.getEmail(),
                new AddressDto(
                 customer.getFirstAddress().getCity(),
                 customer.getFirstAddress().getPostalCode(),
                 customer.getFirstAddress().getAddressLine(),
                 customer.getFirstAddress().getAddressLine2()
                )
        );
    }
}
