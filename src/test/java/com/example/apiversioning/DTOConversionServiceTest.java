package com.example.apiversioning;


import com.example.apiversioning.api.common.versioning.VersioningService;
import com.example.apiversioning.api.customer.dto.AddressDto;
import com.example.apiversioning.api.customer.dto.CustomerDto;
import com.example.apiversioning.api.customer.dto.versioning.*;
import org.junit.jupiter.api.Test;

public class DTOConversionServiceTest {

    @Test
    public void convertToLatestCustomerTest(){
        VersioningService<CustomerDtoVersionable, CustomerDto, CustomerDtoV3> service = new VersioningService<>(CustomerDtoV3.class);
        CustomerDtoV1 v1 = new CustomerDtoV1("Max mustermann",1,new AddressDtoV1("ABC","DEFG"));
        CustomerDtoV2 v2 = service.convertUp(v1, CustomerDtoV2.class);
        CustomerDto baseDto = service.toBaseDto(v2);
        System.out.println(v2);
        System.out.println(baseDto);
    }

    @Test
    public void convertToLowerVersionTest(){
        VersioningService<CustomerDtoVersionable, CustomerDto, CustomerDtoV3> service = new VersioningService<>(CustomerDtoV3.class);
        CustomerDto baseDto = new CustomerDto("Marian","Thiel",1,"marian.thiel@aoe.com", new AddressDto("Darmstadt","64287","Pützerstraße 2","Etage 3"));

        CustomerDtoV1 v1 = service.fromBaseDtoToSpecificVersion(baseDto, CustomerDtoV1.class);


        System.out.println(v1);
        System.out.println(baseDto);
    }
}
