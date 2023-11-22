package com.example.apiversioning.api.customer.dto.versioning;

import lombok.AllArgsConstructor;
import lombok.Data;

import static com.example.apiversioning.api.common.util.VersioningServiceProvider.addressVersioningService;

@Data
@AllArgsConstructor
public class CustomerDtoV2 implements CustomerDtoVersionable {



    private String name;

    private int phoneNumber;

    private AddressDtoV2 firstAddress;

    private AddressDtoV2 secondAddress;

    @Override
    public CustomerDtoVersionable convertUp() {
        return new CustomerDtoV3(
                name,
                "N/A",
                phoneNumber,
                "N/A",
                firstAddress
        );
    }

    @Override
    public CustomerDtoVersionable convertDown() {
        return new CustomerDtoV1(
                name,
                phoneNumber,
                addressVersioningService.convertDown(firstAddress, AddressDtoV1.class)
        );
    }


}
