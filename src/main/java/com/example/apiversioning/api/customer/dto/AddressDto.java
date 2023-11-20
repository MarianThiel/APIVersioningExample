package com.example.apiversioning.api.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddressDto {
    private String city;
    private String addressLine;
    private String addressLine2;
}
