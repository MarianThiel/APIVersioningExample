package com.example.apiversioning.api.customer.dto.versioning;

import com.example.apiversioning.api.customer.dto.AddressDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomerDtoV1 {

    private String name;

    private int phoneNumber;

    private AddressDto firstAddress;

}
