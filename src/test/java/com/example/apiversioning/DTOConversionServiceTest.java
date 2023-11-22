package com.example.apiversioning;


import com.example.apiversioning.api.customer.dto.AddressDto;
import com.example.apiversioning.api.customer.dto.CustomerDto;
import com.example.apiversioning.api.customer.dto.versioning.AddressDtoV1;
import com.example.apiversioning.api.customer.dto.versioning.CustomerDtoV1;
import com.example.apiversioning.api.customer.dto.versioning.CustomerDtoV2;
import org.junit.jupiter.api.Test;

import static com.example.apiversioning.api.common.util.VersioningServiceProvider.customerVersioningService;

public class DTOConversionServiceTest {

    @Test
    public void convertToLatestCustomerTest(){

        CustomerDtoV1 v1 = new CustomerDtoV1("Max mustermann",1,new AddressDtoV1("ABC","DEFG"));
        CustomerDtoV2 v2 = customerVersioningService.convertUp(v1, CustomerDtoV2.class);
        CustomerDto baseDto = customerVersioningService.toBaseDto(v2);
        System.out.println(v2);
        System.out.println(baseDto);
    }

    @Test
    public void convertToLowerVersionTest(){

        CustomerDto baseDto = new CustomerDto("Marian","Thiel",1,"marian.thiel@aoe.com", new AddressDto("Darmstadt","64287","Pützerstraße 2","Etage 3"));

        CustomerDtoV1 v1 = customerVersioningService.fromBaseDtoToSpecificVersion(baseDto, CustomerDtoV1.class);


        System.out.println(v1);
        System.out.println(baseDto);
    }
}
