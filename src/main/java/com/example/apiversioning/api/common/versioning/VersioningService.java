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
public class VersioningService<C extends DtoVersionable<C>, B extends VersioningBase<?,?>> {
    private final Class<? extends C> highestVersion;

    public VersioningService(Class<? extends C> highestVersion) {
        this.highestVersion = highestVersion;
    }

    public <T extends DtoVersionable<C>> T convertUp(C input, Class<T> target) {

        C current = input;
        C prev = null;
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

    public <T extends DtoVersionable<C>> T convertDown(C input, Class<T> target) {

        C current = input;
        C prev = null;
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

    public <T extends HighestVersionable> B toBaseDto(C inputCustomerDto){
        C highestVersionDto = convertUp(inputCustomerDto, highestVersion);

        //return highestVersionToCustomerDto(highestVersionDto);
        return null;
    }

    public <T extends DtoVersionable> T fromCustomerDto(CustomerDto customerDto, Class<T> desiredVersion){
        /*DtoVersionable highestVersion = customerDtoToHighestVersion(customerDto);
        return convertDown(highestVersion, desiredVersion);*/
        return null;
    }

    private CustomerDto highestVersionToCustomerDto(DtoVersionable highestVersionDto){
        var  highestVersionElement = highestVersion.cast(highestVersionDto);

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

    public DtoVersionable customerDtoToHighestVersion(CustomerDto customerDto) {
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
