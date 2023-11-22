package com.example.apiversioning.api.common.util;

import com.example.apiversioning.api.common.versioning.VersioningService;
import com.example.apiversioning.api.common.versioning.VersioningServiceFactory;
import com.example.apiversioning.api.customer.dto.AddressDto;
import com.example.apiversioning.api.customer.dto.CustomerDto;
import com.example.apiversioning.api.customer.dto.versioning.*;

public abstract class VersioningServiceProvider {
    public static final VersioningService<AddressDtoVersionable, AddressDto, AddressDtoV3> addressVersioningService = VersioningServiceFactory.createAddressVersioningService();
    public static final VersioningService<CustomerDtoVersionable, CustomerDto, CustomerDtoV4> customerVersioningService = VersioningServiceFactory.createCustomerVersioningService();
}
