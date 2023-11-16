package com.example.apiversioning.api.customer.dto.versioning;

import com.example.apiversioning.api.common.versioning.CustomerDtoVersionable;
import com.example.apiversioning.api.customer.dto.AddressDto;
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
        return this;
    }

    @Override
    public CustomerDtoVersionable convertDown() {
        AddressDto addressDto = new AddressDto(
                address.getCity(),
                address.getAddressLine() + " " + address.getAddressLine2()
        );
        return new CustomerDtoV2(
                firstName + " " + lastName,
                phoneNumber,
                addressDto,
                addressDto
        );
    }


}
