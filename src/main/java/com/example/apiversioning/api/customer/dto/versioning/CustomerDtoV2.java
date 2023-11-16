package com.example.apiversioning.api.customer.dto.versioning;

import com.example.apiversioning.api.common.versioning.CustomerDtoVersionable;
import com.example.apiversioning.api.customer.dto.AddressDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomerDtoV2 implements CustomerDtoVersionable {

    private String name;

    private int phoneNumber;

    private AddressDto firstAddress;

    private AddressDto secondAddress;

    @Override
    public CustomerDtoVersionable convertUp() {
        return new CustomerDtoV3(
                name,
                "N/A",
                phoneNumber,
                "N/A",
                new AddressDtoV2(
                        firstAddress.getCity(),
                        firstAddress.getAddressLine(),
                        "N/A"
                )
        );
    }

    @Override
    public CustomerDtoVersionable convertDown() {
        return new CustomerDtoV1(
                name,
                phoneNumber,
                firstAddress
        );
    }


}
