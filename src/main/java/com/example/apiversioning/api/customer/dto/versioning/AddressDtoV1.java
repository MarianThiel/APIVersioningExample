package com.example.apiversioning.api.customer.dto.versioning;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddressDtoV1 {
    private String city;
    private String addressLine;
}
