package com.example.apiversioning.api.common.conv.adapter;

import com.example.apiversioning.api.common.conv.Adapter;
import com.example.apiversioning.api.customer.dto.AddressDto;
import com.example.apiversioning.api.customer.dto.versioning.CustomerDtoV1;
import com.example.apiversioning.api.customer.dto.versioning.CustomerDtoV2;
import com.example.apiversioning.api.customer.dto.versioning.CustomerDtoV3;

public class CustomerDtoV1V2Adapter extends Adapter<CustomerDtoV1, CustomerDtoV2> {


    public CustomerDtoV1V2Adapter() {
        super(CustomerDtoV1.class, CustomerDtoV2.class);
    }

    @Override
    protected CustomerDtoV2 convertForward(Object input) {
        if(!(input instanceof CustomerDtoV1)){
            throw new IllegalArgumentException("input object must be type of " + CustomerDtoV1.class);
        }
        CustomerDtoV1 dtoInput = (CustomerDtoV1) input;
        return new CustomerDtoV2(dtoInput.getName(), dtoInput.getPhoneNumber(), dtoInput.getFirstAddress(), dtoInput.getFirstAddress());
    }

    @Override
    protected CustomerDtoV1 convertBackward(Object input) {
        if(!(input instanceof CustomerDtoV2)){
            throw new IllegalArgumentException("input object must be type of " + CustomerDtoV2.class);
        }
        CustomerDtoV2 dtoInput = (CustomerDtoV2) input;
        return new CustomerDtoV1(dtoInput.getName(), dtoInput.getPhoneNumber(), dtoInput.getFirstAddress());
    }
}
