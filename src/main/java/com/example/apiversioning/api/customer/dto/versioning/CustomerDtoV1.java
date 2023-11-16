package com.example.apiversioning.api.customer.dto.versioning;

import com.example.apiversioning.api.common.versioning.CustomerDtoVersionable;
import com.example.apiversioning.api.customer.dto.AddressDto;
import com.example.apiversioning.api.customer.dto.CustomerDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomerDtoV1 implements CustomerDtoVersionable {

    private String name;

    private int phoneNumber;

    private AddressDto firstAddress;

    @Override
    public CustomerDtoVersionable convertUp() {
        return null;
    }

    @Override
    public CustomerDtoVersionable convertDown() {
        return null;
    }

    @Override
    public CustomerDto toCustomerDto() {
        return null;
    }
}
