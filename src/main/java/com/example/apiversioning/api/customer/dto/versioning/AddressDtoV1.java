package com.example.apiversioning.api.customer.dto.versioning;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddressDtoV1 implements AddressDtoVersionable {
    private String city;
    private String addressLine;

    @Override
    public AddressDtoVersionable convertUp() {
        return new AddressDtoV2(
          city,
          addressLine,
          "N/A"
        );
    }

    @Override
    public AddressDtoVersionable convertDown() {
        return this;
    }
}
