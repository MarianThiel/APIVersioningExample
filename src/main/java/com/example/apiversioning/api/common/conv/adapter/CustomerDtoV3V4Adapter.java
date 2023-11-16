package com.example.apiversioning.api.common.conv.adapter;

import com.example.apiversioning.api.common.conv.Adapter;
import com.example.apiversioning.api.customer.dto.CustomerDto;
import com.example.apiversioning.api.customer.dto.versioning.CustomerDtoV1;
import com.example.apiversioning.api.customer.dto.versioning.CustomerDtoV3;

import java.util.List;

public class CustomerDtoV3V4Adapter extends Adapter<CustomerDtoV3, CustomerDto> {
    public CustomerDtoV3V4Adapter() {
        super(CustomerDtoV3.class, CustomerDto.class);
    }

    @Override
    protected CustomerDto convertForward(Object input) {
        if(!(input instanceof CustomerDtoV3)){
            throw new IllegalArgumentException("input object must be type of " + CustomerDtoV3.class);
        }
        CustomerDtoV3 dtoInput = (CustomerDtoV3) input;
        return new CustomerDto(
                dtoInput.getFirstName(),
                dtoInput.getLastName(),
                dtoInput.getPhoneNumber(),
                dtoInput.getEmail(),
                List.of(dtoInput.getAddress())
        );
    }

    @Override
    protected CustomerDtoV3 convertBackward(Object input) {
        if(!(input instanceof CustomerDto)){
            throw new IllegalArgumentException("input object must be type of " + CustomerDto.class);
        }
        return null;
    }
}
