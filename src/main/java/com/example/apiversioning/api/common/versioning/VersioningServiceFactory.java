package com.example.apiversioning.api.common.versioning;

import com.example.apiversioning.api.customer.dto.AddressDto;
import com.example.apiversioning.api.customer.dto.CustomerDto;
import com.example.apiversioning.api.customer.dto.versioning.*;

public abstract class VersioningServiceFactory {
    public static VersioningService<CustomerDtoVersionable, CustomerDto, CustomerDtoV4> createCustomerVersioningService(){
        return new VersioningService<>(CustomerDtoV4.class);
    }

    public static VersioningService<AddressDtoVersionable, AddressDto, AddressDtoV3> createAddressVersioningService(){
        return new VersioningService<>(AddressDtoV3.class);
    }
}
