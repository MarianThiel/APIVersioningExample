package com.example.apiversioning;


import com.example.apiversioning.api.customer.dto.AddressDto;
import com.example.apiversioning.api.customer.dto.CustomerDto;
import com.example.apiversioning.api.customer.dto.versioning.CustomerDtoV2;
import org.junit.jupiter.api.Test;

public class DTOConversionServiceTest {

    @Test
    public void convertToLatestTest(){
        AddressDto addressDto = new AddressDto("Frankfurt","Musterstraße 2");
        CustomerDtoV2 customerDtoV2 = new CustomerDtoV2("Max", 2131, addressDto, addressDto);



    }
}
