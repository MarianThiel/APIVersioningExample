package com.example.apiversioning.api.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDto {


    private String firstName;

    private String lastName;

    private int phoneNumber;

    private String email;

    private AddressDto address;


}
