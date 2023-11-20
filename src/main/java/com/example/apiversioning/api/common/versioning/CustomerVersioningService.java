package com.example.apiversioning.api.common.versioning;

import com.example.apiversioning.api.customer.dto.AddressDto;
import com.example.apiversioning.api.customer.dto.CustomerDto;
import com.example.apiversioning.api.customer.dto.versioning.AddressDtoV2;
import com.example.apiversioning.api.customer.dto.versioning.CustomerDtoV3;
import org.springframework.stereotype.Service;


/**
 * Problematic at runtime, requires to chain all Versionable objects together.
 * Also cyclic chaining is possible as well as none reachable versions
 */
@Service
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
        return highestVersionToCustomerDto(highestVersionDto);
    }

    public <T extends CustomerDtoVersionable> T fromCustomerDto(CustomerDto customerDto, Class<T> desiredVersion){
        CustomerDtoVersionable highestVersion = customerDtoToHighestVersion(customerDto);
        return convertDown(highestVersion, desiredVersion);
    }

    private CustomerDto highestVersionToCustomerDto(CustomerDtoVersionable highestVersionDto){
        var  highestVersionElement = HIGHEST_VERSION_CLASS.cast(highestVersionDto);

        return new CustomerDto(
                highestVersionElement.getFirstName(),
                highestVersionElement.getLastName(),
                highestVersionElement.getPhoneNumber(),
                highestVersionElement.getEmail(),
                new AddressDto(
                        highestVersionElement.getAddress().getCity(),
                        highestVersionElement.getAddress().getAddressLine(),
                        highestVersionElement.getAddress().getAddressLine2()
                )
        );
    }

    public CustomerDtoVersionable customerDtoToHighestVersion(CustomerDto customerDto) {
        return new CustomerDtoV3(
            customerDto.getFirstName(),
            customerDto.getLastName(),
            customerDto.getPhoneNumber(),
            customerDto.getEmail(),
            new AddressDtoV2(
                    customerDto.getAddress().getCity(),
                    customerDto.getAddress().getAddressLine(),
                    customerDto.getAddress().getAddressLine2()
            )
        );
    }

}
