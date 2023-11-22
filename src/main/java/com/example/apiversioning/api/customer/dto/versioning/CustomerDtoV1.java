package com.example.apiversioning.api.customer.dto.versioning;

import com.example.apiversioning.api.common.versioning.VersioningService;
import com.example.apiversioning.api.common.versioning.VersioningServiceFactory;
import com.example.apiversioning.api.customer.dto.AddressDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDtoV1 implements CustomerDtoVersionable {

    private static VersioningService<AddressDtoVersionable, AddressDto, AddressDtoV2> versioningService = VersioningServiceFactory.createAddressVersioningService();

    private String name;

    private int phoneNumber;

    private AddressDtoV1 firstAddress;

    @Override
    public CustomerDtoVersionable convertUp() {
        return new CustomerDtoV2(
                name,
                phoneNumber,
                versioningService.convertUp(firstAddress, AddressDtoV2.class),
                versioningService.convertUp(firstAddress, AddressDtoV2.class)

        );
    }

    @Override
    public CustomerDtoVersionable convertDown() {
        return this;
    }


}
