package com.example.apiversioning.api.customer.dto.versioning;

import com.example.apiversioning.api.common.versioning.HighestVersionable;
import com.example.apiversioning.api.common.versioning.VersioningService;
import com.example.apiversioning.api.common.versioning.VersioningServiceFactory;
import com.example.apiversioning.api.customer.dto.AddressDto;
import com.example.apiversioning.api.customer.dto.CustomerDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import static com.example.apiversioning.api.common.util.VersioningServiceProvider.addressVersioningService;
@Data
@AllArgsConstructor
public class CustomerDtoV4 implements CustomerDtoVersionable, HighestVersionable<CustomerDto> {

    private static VersioningService<AddressDtoVersionable, AddressDto, AddressDtoV3> versioningService = VersioningServiceFactory.createAddressVersioningService();

    private String firstName;

    private String lastName;

    private int phoneNumber;

    private String email;

    private AddressDtoV3 address;




    @Override
    public CustomerDtoVersionable convertUp() {
        return this;
    }

    @Override
    public CustomerDtoVersionable convertDown() {
        return new CustomerDtoV3(
                firstName,
                lastName,
                phoneNumber,
                email,
                addressVersioningService.convertDown(address, AddressDtoV2.class)
        );
    }

    @Override
    public CustomerDto toBaseDto() {
        return new CustomerDto(
                firstName,
                lastName,
                phoneNumber,
                email,
                addressVersioningService.toBaseDto(address)
        );
    }
}
