package com.example.apiversioning.api.customer.dto;

import com.example.apiversioning.api.common.versioning.VersioningBase;
import com.example.apiversioning.api.customer.dto.versioning.AddressDtoV2;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddressDto implements VersioningBase<AddressDtoV2> {
    private String city;
    private String addressLine;
    private String addressLine2;

    @Override
    public AddressDtoV2 toHighestDto() {
        return new AddressDtoV2(
          city,
          addressLine,
          addressLine2
        );
    }
}
