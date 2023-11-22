package com.example.apiversioning.api.customer.dto.versioning;

import com.example.apiversioning.api.common.versioning.VersioningService;
import com.example.apiversioning.api.common.versioning.VersioningServiceFactory;
import com.example.apiversioning.api.customer.dto.AddressDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDtoV2 implements CustomerDtoVersionable {

    private static VersioningService<AddressDtoVersionable, AddressDto, AddressDtoV2> versioningService = VersioningServiceFactory.createAddressVersioningService();

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
                versioningService.convertDown(firstAddress, AddressDtoV1.class)
        );
    }


}
