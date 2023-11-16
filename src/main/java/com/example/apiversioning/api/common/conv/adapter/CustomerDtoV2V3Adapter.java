package com.example.apiversioning.api.common.conv.adapter;

import com.example.apiversioning.api.common.conv.Adapter;
import com.example.apiversioning.api.customer.dto.versioning.AddressDtoV2;
import com.example.apiversioning.api.customer.dto.versioning.CustomerDtoV1;
import com.example.apiversioning.api.customer.dto.versioning.CustomerDtoV2;
import com.example.apiversioning.api.customer.dto.versioning.CustomerDtoV3;

public class CustomerDtoV2V3Adapter extends Adapter<CustomerDtoV2, CustomerDtoV3> {
    public CustomerDtoV2V3Adapter() {
        super(CustomerDtoV2.class, CustomerDtoV3.class);
    }

    @Override
    protected CustomerDtoV3 convertForward(Object input) {
        if(!(input instanceof CustomerDtoV2)){
            throw new IllegalArgumentException("input object must be type of " + CustomerDtoV2.class);
        }
        CustomerDtoV2 dtoInput = (CustomerDtoV2) input;
        return new CustomerDtoV3(
                dtoInput.getName(),
                "N/A",
                dtoInput.getPhoneNumber(),
                "N/A", new AddressDtoV2(
                dtoInput.getFirstAddress().getCity(),
                dtoInput.getFirstAddress().getAddressLine(),
                "N/A"
                ));
    }

    @Override
    protected CustomerDtoV2 convertBackward(Object input) {
        if(!(input instanceof CustomerDtoV3)){
            throw new IllegalArgumentException("input object must be type of " + CustomerDtoV3.class);
        }

        return null;
    }
}
