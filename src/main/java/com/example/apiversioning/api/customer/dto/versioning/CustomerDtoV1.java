package com.example.apiversioning.api.customer.dto.versioning;

import lombok.AllArgsConstructor;
import lombok.Data;

import static com.example.apiversioning.api.common.util.VersioningServiceProvider.addressVersioningService;

@Data
@AllArgsConstructor
public class CustomerDtoV1 implements CustomerDtoVersionable {


    private String name;

    private int phoneNumber;

    private AddressDtoV1 firstAddress;

    @Override
    public CustomerDtoVersionable convertUp() {
        return new CustomerDtoV2(
                name,
                phoneNumber,
                addressVersioningService.convertUp(firstAddress, AddressDtoV2.class),
                addressVersioningService.convertUp(firstAddress, AddressDtoV2.class)

        );
    }

    @Override
    public CustomerDtoVersionable convertDown() {
        return this;
    }


}
