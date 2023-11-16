package com.example.apiversioning.api.customer.dto.versioning;

import com.example.apiversioning.api.common.versioning.CustomerDtoVersionable;
import com.example.apiversioning.api.customer.dto.CustomerDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomerDtoV3 implements CustomerDtoVersionable {

    private String firstName;

    private String lastName;

    private int phoneNumber;

    private String email;

    private AddressDtoV2 address;

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
