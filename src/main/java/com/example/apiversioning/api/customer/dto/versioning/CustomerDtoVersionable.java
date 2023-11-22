package com.example.apiversioning.api.customer.dto.versioning;

import com.example.apiversioning.api.common.versioning.DtoVersionable;
import com.example.apiversioning.api.customer.dto.CustomerDto;

public interface CustomerDtoVersionable extends DtoVersionable<CustomerDtoVersionable>{

    static Class<CustomerDtoV3> HIGHEST_VERSION_CLASS = CustomerDtoV3.class;

    static CustomerDto toCustomerDtoFromHighestVersion(CustomerDtoV3 highestVersion){
        return null;
    }

    static CustomerDtoV3 fromCustomerDtoToHighestVersion(CustomerDto customerDto){
        return null;
    }

}
