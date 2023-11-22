package com.example.apiversioning.api.customer.dto.versioning;

import com.example.apiversioning.api.common.versioning.HighestVersionable;
import com.example.apiversioning.api.customer.dto.AddressDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddressDtoV2 implements AddressDtoVersionable, HighestVersionable<AddressDto> {
    private String city;
    private String addressLine;
    private String addressLine2;

    @Override
    public AddressDtoVersionable convertUp() {
        return this;
    }

    @Override
    public AddressDtoVersionable convertDown() {
        return new AddressDtoV1(
                city,
                addressLine + " " + addressLine2
        );
    }

    @Override
    public AddressDto toBaseDto() {
        return new AddressDto(
                city,
                addressLine,
                addressLine2
        );
    }
}
