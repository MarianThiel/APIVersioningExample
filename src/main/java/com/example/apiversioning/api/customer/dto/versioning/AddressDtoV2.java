package com.example.apiversioning.api.customer.dto.versioning;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddressDtoV2 {
    private String city;
    private String addressLine;
    private String addressLine2;
}
