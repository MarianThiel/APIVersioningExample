package com.example.apiversioning;


import com.example.apiversioning.api.common.versioning.CustomerVersioningService;
import com.example.apiversioning.api.customer.dto.AddressDto;
import com.example.apiversioning.api.customer.dto.CustomerDto;
import com.example.apiversioning.api.customer.dto.versioning.AddressDtoV2;
import com.example.apiversioning.api.customer.dto.versioning.CustomerDtoV1;
import com.example.apiversioning.api.customer.dto.versioning.CustomerDtoV2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DTOConversionServiceTest {

    @Test
    public void convertToLatestTest(){
        AddressDto addressDto = new AddressDto("Frankfurt","Musterstraße 2");
        CustomerDtoV2 customerDtoV2 = new CustomerDtoV2("Max", 2131, addressDto, addressDto);
        CustomerVersioningService customerVersioningService = new CustomerVersioningService();

        CustomerDto highestCustomer = customerVersioningService.toCustomerDto(customerDtoV2);

        Assertions.assertEquals(highestCustomer.getFirstName(), customerDtoV2.getName());
    }

    @Test
    public void convertToLowerVersionTest(){
        AddressDtoV2 addressDto = new AddressDtoV2("Darmstadt","Musterstraße 2", "64287");
        CustomerVersioningService customerVersioningService = new CustomerVersioningService();

        CustomerDto customerDto = new CustomerDto("Max", "Mustermann", 1234, "max.mustermann@test.de", addressDto);

        CustomerDtoV1 customerDtoV1 = customerVersioningService.fromCustomerDto(customerDto, CustomerDtoV1.class);

        Assertions.assertEquals("Max Mustermann", customerDtoV1.getName());
    }
}
