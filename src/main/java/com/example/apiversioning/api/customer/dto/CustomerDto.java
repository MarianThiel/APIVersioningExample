package com.example.apiversioning.api.customer.dto;

import com.example.apiversioning.api.common.versioning.VersioningBase;
import com.example.apiversioning.api.common.versioning.VersioningService;
import com.example.apiversioning.api.common.versioning.VersioningServiceFactory;
import com.example.apiversioning.api.customer.dto.versioning.AddressDtoV2;
import com.example.apiversioning.api.customer.dto.versioning.AddressDtoV3;
import com.example.apiversioning.api.customer.dto.versioning.AddressDtoVersionable;
import com.example.apiversioning.api.customer.dto.versioning.CustomerDtoV3;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDto implements VersioningBase<CustomerDtoV3> {

    private static VersioningService<AddressDtoVersionable, AddressDto, AddressDtoV3> versioningService = VersioningServiceFactory.createAddressVersioningService();

    private String firstName;

    private String lastName;

    private int phoneNumber;

    private String email;

    private AddressDto address;


    @Override
    public CustomerDtoV3 toHighestDto() {
        return new CustomerDtoV3(
                getFirstName(),
                getLastName(),
                getPhoneNumber(),
                getEmail(),
                versioningService.fromBaseDtoToSpecificVersion(address, AddressDtoV2.class)
        );
    }
}
