package com.example.apiversioning.api.customer.dto.versioning;

import com.example.apiversioning.api.customer.dto.AddressDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CustomerDtoV3 {

    private String firstName;

    private String lastName;

    private int phoneNumber;

    private String email;

    private AddressDtoV2 address;

}
