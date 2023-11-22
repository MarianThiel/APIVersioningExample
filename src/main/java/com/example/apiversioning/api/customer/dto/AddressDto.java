package com.example.apiversioning.api.customer.dto;

import com.example.apiversioning.api.common.versioning.VersioningBase;
import com.example.apiversioning.api.customer.dto.versioning.AddressDtoV3;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddressDto implements VersioningBase<AddressDtoV3> {
    private String city;
    private String postalCode;
    private String addressLine;
    private String addressLine2;

    @Override
    public AddressDtoV3 toHighestDto() {
        return new AddressDtoV3(
          city,
          postalCode,
          addressLine,
          addressLine2
        );
    }
}
