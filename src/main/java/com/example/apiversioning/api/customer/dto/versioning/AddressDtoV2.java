package com.example.apiversioning.api.customer.dto.versioning;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddressDtoV2 implements AddressDtoVersionable {
    private String city;
    private String addressLine;
    private String addressLine2;

    @Override
    public AddressDtoVersionable convertUp() {
        return new AddressDtoV3(city, "N/A", addressLine, addressLine2);
    }

    @Override
    public AddressDtoVersionable convertDown() {
        return new AddressDtoV1(
                city,
                addressLine + " " + addressLine2
        );
    }


}
