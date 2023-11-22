package com.example.apiversioning.api.customer.dto;

import com.example.apiversioning.api.common.versioning.VersioningBase;
import com.example.apiversioning.api.customer.dto.versioning.CustomerDtoV3;
import com.example.apiversioning.api.customer.dto.versioning.CustomerDtoVersionable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDto implements VersioningBase<CustomerDto, CustomerDtoV3> {


    private String firstName;

    private String lastName;

    private int phoneNumber;

    private String email;

    private AddressDto address;


    @Override
    public CustomerDtoV3 fromBaseToHighestDto(CustomerDto base) {
        return null;
    }

    @Override
    public CustomerDto toBaseFromHighestDto(CustomerDtoV3 highestVersion) {
        return null;
    }


}
