package com.example.apiversioning.api.common.versioning;

import com.example.apiversioning.api.customer.dto.AddressDto;
import com.example.apiversioning.api.customer.dto.CustomerDto;
import com.example.apiversioning.api.customer.dto.versioning.AddressDtoV2;
import com.example.apiversioning.api.customer.dto.versioning.AddressDtoVersionable;
import com.example.apiversioning.api.customer.dto.versioning.CustomerDtoV3;
import com.example.apiversioning.api.customer.dto.versioning.CustomerDtoVersionable;

public abstract class VersioningServiceFactory {
    public static VersioningService<CustomerDtoVersionable, CustomerDto, CustomerDtoV3> createCustomerVersioningService(){
        return new VersioningService<>(CustomerDtoV3.class);
    }

    public static VersioningService<AddressDtoVersionable, AddressDto, AddressDtoV2> createAddressVersioningService(){
        return new VersioningService<>(AddressDtoV2.class);
    }
}
