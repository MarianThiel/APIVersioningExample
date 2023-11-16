package com.example.apiversioning.api.common.versioning;

import com.example.apiversioning.api.customer.dto.CustomerDto;

public interface CustomerDtoVersionable {

    CustomerDtoVersionable convertUp();

    CustomerDtoVersionable convertDown();

    CustomerDto toCustomerDto();

}
