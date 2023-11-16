package com.example.apiversioning;

import com.example.apiversioning.api.common.conv.ObjectTransformer;
import com.example.apiversioning.api.common.conv.DtoConverter;
import com.example.apiversioning.api.common.conv.adapter.CustomerDtoV1V2ObjectTransformer;
import com.example.apiversioning.api.common.conv.adapter.CustomerDtoV2V3ObjectTransformer;
import com.example.apiversioning.api.common.conv.adapter.CustomerDtoV3V4ObjectTransformer;
import com.example.apiversioning.api.customer.dto.AddressDto;
import com.example.apiversioning.api.customer.dto.CustomerDto;
import com.example.apiversioning.api.customer.dto.versioning.CustomerDtoV2;
import org.junit.jupiter.api.Test;

public class DTOConversionServiceTest {

    @Test
    public void convertToLatestTest(){
        AddressDto addressDto = new AddressDto("Frankfurt","Musterstraße 2");
        CustomerDtoV2 customerDtoV2 = new CustomerDtoV2("Max", 2131, addressDto, addressDto);


        ObjectTransformer<?,?>[] objectTransformers = {
                new CustomerDtoV1V2ObjectTransformer(),
                new CustomerDtoV2V3ObjectTransformer(),
                new CustomerDtoV3V4ObjectTransformer()
        };

        DtoConverter ac = new DtoConverter(objectTransformers);

        CustomerDto c = ac.convertUp(customerDtoV2, CustomerDto.class);

        System.out.println(c);
    }
}
