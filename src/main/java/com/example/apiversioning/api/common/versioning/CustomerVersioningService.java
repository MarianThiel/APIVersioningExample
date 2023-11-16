package com.example.apiversioning.api.common.versioning;

import com.example.apiversioning.api.customer.dto.CustomerDto;
import com.example.apiversioning.api.customer.dto.versioning.CustomerDtoV3;

/**
 * Problematic at runtime, requires to chain all Versionable objects together.
 * Also cyclic chaining is possible as well as none reachable versions
 */
public class CustomerVersioningService {


    private final Class<CustomerDtoV3> HIGHEST_VERSION_CLASS = CustomerDtoV3.class;


    public <T extends CustomerDtoVersionable> T convertUp(CustomerDtoVersionable input, Class<T> target) {

        CustomerDtoVersionable current = input;
        CustomerDtoVersionable prev = null;
        while(prev != current){
            if(target.isInstance(current)){
                //noinspection unchecked
                return (T) current;
            }
            prev = current;
            current = current.convertUp();

        }
        if(current.getClass().isInstance(target)){
            //noinspection unchecked
            return (T) current;
        }

        throw new IllegalStateException(("target class %s is not reachable").formatted(target));
    }

    public <T extends CustomerDtoVersionable> T convertDown(CustomerDtoVersionable input, Class<T> target) {

        CustomerDtoVersionable current = input;
        CustomerDtoVersionable prev = null;
        while(prev != current){
            if(target.isInstance(current)){
                //noinspection unchecked
                return (T) current;
            }
            prev = current;
            current = current.convertDown();

        }
        if(current.getClass().isInstance(target)){
            //noinspection unchecked
            return (T) current;
        }

        throw new IllegalStateException(("target class %s is not reachable").formatted(target));
    }

    public CustomerDto toCustomerDto(CustomerDtoVersionable inputCustomerDto){
        CustomerDtoVersionable highestVersionDto = convertUp(inputCustomerDto, HIGHEST_VERSION_CLASS);

         var  highestVersionElement = HIGHEST_VERSION_CLASS.cast(highestVersionDto);

         return new CustomerDto(
                 highestVersionElement.getFirstName(),
                 highestVersionElement.getLastName(),
                 highestVersionElement.getPhoneNumber(),
                 highestVersionElement.getEmail(),
                 highestVersionElement.getAddress()
         );

    }

}
